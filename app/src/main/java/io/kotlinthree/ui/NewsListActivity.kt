package io.kotlinthree.ui

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import io.kotlinthree.R
import io.kotlinthree.api.ApiUtil
import io.kotlinthree.api.News
import io.kotlinthree.api.NewsListData
import io.kotlinthree.extension.addPair
import io.kotlinthree.extension.findView
import io.kotlinthree.extension.showToast
import io.kotlinthree.extension.start
import io.kotlinthree.ui.base.BaseActivity
import io.kotlinthree.util.DateUtil
import io.kotlinthree.util.LogUtils
import retrofit.Callback
import retrofit.Response
import retrofit.Retrofit
import java.util.*

/**
 * Created by jameson on 12/19/15.
 */
class NewsListActivity : BaseActivity(), AdapterView.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null
    private var mListView: ListView? = null
    private var mAdapter: NewsListAdapter? = null
    private var mList: List<News> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        initViews()
        loadData()
    }

    private fun initViews() {
        mSwipeRefreshLayout = findView<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        mListView = findView<ListView>(R.id.listView)
        mAdapter = NewsListAdapter(this, mList)
        mListView!!.adapter = mAdapter
        mListView!!.onItemClickListener = this

        mSwipeRefreshLayout!!.setOnRefreshListener(this)
    }

    private fun loadData() {
        val date = DateUtil.getDateStr(System.currentTimeMillis(), "yyyyMMdd")
        val call = ApiUtil.getService().listNews(date)
        call.enqueue(object : Callback<NewsListData> {
            override fun onResponse(response: Response<NewsListData>, retrofit: Retrofit) {
                mSwipeRefreshLayout!!.isRefreshing = false
                val statusCode = response.code()
                LogUtils.i(statusCode.toString())
                if (response.isSuccess) {
                    mList = response.body().stories
                    mAdapter!!.notifyDataSetChanged(mList)
                }
            }

            override fun onFailure(t: Throwable) {
                mSwipeRefreshLayout!!.isRefreshing = false
                if (t.message != null) {
                    showToast(t.message!!.toString())
                }
            }
        })

    }

    override fun onRefresh() {
        mListView!!.postDelayed({ loadData() }, 1000)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        start<NewsDetailActivity>(Bundle().addPair("news_id", mList[position].id))
    }
}
