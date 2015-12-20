package io.kotlinthree.util

import org.jsoup.Jsoup

/**
 * Created by jameson on 12/20/15.
 */
object ZhihuWebUtil {
    /**
     * 设置图片最大宽度
     * @param body
     * *
     * @return
     */
    val wrapper = { body: String ->
        "<html> <head> <style type='text/css'> img {height: auto !important; max-width: 100% !important;} </style> </head>$body</html>"
    }

    val wrapperHeader = { headTitle: String, headImageSource: String, headImageUrl: String ->
        "<div class=\"img-wrap\"> <h1 class=\"headline-title\">$headTitle</h1> <span class=\"img-source\"> $headImageSource</span><img src=\"$headImageUrl\" alt=\"\"><div class=\"img-mask\"></div>"
    }

    /**
     * html中的img添加openImage事件
     */
    fun wrapperOpenImage(html: String): String {
        val doc = Jsoup.parse(html)
        val es = doc.getElementsByTag("img")
        for (e in es) {
            val imgUrl = e.attr("src")
            if (e.attr("class") != "avatar") {
                e.attr("onclick", "openImage('$imgUrl')")
            }
        }

        return doc.html()
    }

    fun wrapperBody(body: String, headTitle: String, headImageSource: String, headImageUrl: String): String {
        var html = body;
        val header = wrapperHeader(headTitle, headImageSource, headImageUrl);
        // 头部图片布局
        html = html.replace("<div class=\"img-place-holder\">", header)
        // 添加点击事件
        html = wrapperOpenImage(html);

        return html
    }
}
