package io.kotlinthree.util;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtils
 */
public class ToastUtils {

    private static Toast mToast;

    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }

    public static void show(Context context, CharSequence text) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        if (text == null || text.length() == 0) {
            return;
        }
        mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
