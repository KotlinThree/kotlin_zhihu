package io.kotlinthree.extension

import android.view.View

/**
 * Created by jameson on 12/19/15.
 */

fun <T : View> View.findView(id: Int): T = findViewById(id) as T

fun View.slideExit() {
    if (translationY == 0f) animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f) animate().translationY(0f)
}