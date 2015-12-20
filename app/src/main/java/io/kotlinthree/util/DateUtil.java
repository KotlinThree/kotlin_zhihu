package io.kotlinthree.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jameson on 12/19/15.
 */
public class DateUtil {

    /**
     * 获取时间格式
     *
     * @param millSeconds 毫秒值
     * @param format      如yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateStr(long millSeconds, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        String dateStr = formatter.format(new Date(millSeconds));
        return dateStr;
    }
}
