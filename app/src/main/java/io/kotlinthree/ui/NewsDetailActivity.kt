package io.kotlinthree.ui

import android.app.Activity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import io.kotlinthree.Constants
import io.kotlinthree.R
import io.kotlinthree.api.ApiUtil
import io.kotlinthree.api.News
import io.kotlinthree.extension.findView
import io.kotlinthree.extension.showToast
import io.kotlinthree.ui.base.BaseActivity
import io.kotlinthree.util.AssetsUtils
import io.kotlinthree.util.LogUtils
import io.kotlinthree.util.ZhihuWebUtil
import retrofit.Callback
import retrofit.Response
import retrofit.Retrofit
import java.util.*

/**
 * Created by jameson on 12/19/15.
 */
class NewsDetailActivity : BaseActivity() {

    private var mNewsId: Int = 0
    private lateinit var mNews: News
    private lateinit var mWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_news_detail)

        mNewsId = intent.getIntExtra("news_id", 0)
        initViews()
        loadData()
    }

    private fun initViews() {
        mWebView = findView<WebView>(R.id.webView);
        mWebView.settings.javaScriptEnabled = true
        mWebView.addJavascriptInterface(JavaScriptObject(this), "injectedObject")
        // 设置缓存模式
        mWebView.getSettings().cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        mWebView.setWebViewClient(MyWebViewClient())
    }

    private fun loadData() {
        val call = ApiUtil.getService().getNewsDetail(mNewsId)
        call.enqueue(object : Callback<News> {
            override fun onResponse(response: Response<News>, retrofit: Retrofit) {
                val statusCode = response.code()
                LogUtils.i(statusCode.toString())
                if (response.isSuccess) {
                    mNews = response.body()
                    var html = AssetsUtils.loadText(mContext, Constants.TEMPLATE_DEF_URL)
                    html = html.replace("{content}", mNews.body)
                    var headerDef = "file:///android_asset/www/news_detail_header_def.jpg"
                    headerDef = mNews.image
                    val wrapperBody = ZhihuWebUtil.wrapperBody(html, mNews.title, mNews.image_source, headerDef)
                    mWebView.loadDataWithBaseURL(null, wrapperBody, "text/html", "UTF-8", null)
                    // mWebView.loadData(wrapperBody, "text/html; charset=UTF-8", null)
                }
            }

            override fun onFailure(t: Throwable) {
                if (t.message != null) {
                    showToast(t.message.toString())
                }
            }
        })
    }

    class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            super.shouldOverrideUrlLoading(view, url)
            view?.loadUrl(url);
            //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
            return true
        }
    }

    class JavaScriptObject(private val mInstance: Activity?) {

        @JavascriptInterface
        fun openImage(url: String) {
            if (mInstance != null && !mInstance.isFinishing) {
                ImageActivity.start(mInstance, url)
            }
        }
    }

}