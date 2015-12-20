package io.kotlinthree.extension

import android.view.View
import android.view.ViewGroup

/**
 * Created by jameson on 12/19/15.
 */

val ViewGroup.views: List<View>
    get() = (0..childCount - 1).map { getChildAt(it) }