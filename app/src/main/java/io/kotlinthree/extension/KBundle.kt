package io.kotlinthree.extension

import android.os.Bundle

/**
 * Created by jameson on 12/20/15.
 */

inline fun Bundle.addPair(key: String, value: String): Bundle {
    this.putString(key, value)
    return this;
}

inline fun Bundle.addPair(key: String, value: Int): Bundle {
    this.putInt(key, value)
    return this;
}