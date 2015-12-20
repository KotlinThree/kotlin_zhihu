package io.kotlinthree.extension

import android.app.Activity
import android.view.View
import android.widget.Toast
import io.kotlinthree.util.ToastUtils

/**
 * Created by jameson on 12/18/15.
 */

fun <T : View> Activity.findView(resId: Int) = this.findViewById(resId) as T;

fun Activity.showToast(msg: String) {
    ToastUtils.show(this, msg)
}

fun Activity.showToast(msg: Int) {
    ToastUtils.show(this, msg)
}