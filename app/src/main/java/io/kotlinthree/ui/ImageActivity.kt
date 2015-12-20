package io.kotlinthree.ui

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import io.kotlinthree.R
import io.kotlinthree.extension.addPair
import io.kotlinthree.extension.findView
import io.kotlinthree.extension.start
import io.kotlinthree.ui.base.BaseActivity

/**
 * Created by jameson on 12/20/15.
 */
class ImageActivity : BaseActivity() {

    companion object {
        fun start(context: Activity, imageUrl: String) {
            context.start<ImageActivity>(Bundle().addPair("imageUrl", imageUrl))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_image)

        initViews();
    }

    private fun initViews() {
        val imageUrl = intent.getStringExtra("imageUrl");
        Glide.with(this).load(imageUrl).crossFade().into(findView(R.id.imageView));
    }
}