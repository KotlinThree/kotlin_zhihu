package io.kotlinthree.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by jameson on 12/18/15.
 */
public open class BaseActivity : AppCompatActivity() {
    public var mContext: Context? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this;
    }
}