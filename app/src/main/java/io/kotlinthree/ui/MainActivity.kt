package io.kotlinthree.ui

import android.os.Bundle

import io.kotlinthree.R
import io.kotlinthree.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

}

