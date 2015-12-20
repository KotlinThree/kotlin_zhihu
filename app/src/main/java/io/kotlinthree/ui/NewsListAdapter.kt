package io.kotlinthree.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import io.kotlinthree.R
import io.kotlinthree.api.News
import io.kotlinthree.ui.base.HBaseAdapter
import io.kotlinthree.util.HViewHolder

/**
 * Created by jameson on 12/19/15.
 */
class NewsListAdapter(context: Context, list: List<News>) : HBaseAdapter<News>(context, list) {

    override fun onNewItemViewRes(): Int {
        return R.layout.item_news_list
    }

    override fun onBindItemView(convertView: View, data: News, position: Int, parent: ViewGroup) {
        HViewHolder.getTextView(convertView, R.id.title).text = data.title
        Glide.with(context).load(data.images[0]).crossFade().into(HViewHolder.getImageView(convertView, R.id.image));
    }
}
