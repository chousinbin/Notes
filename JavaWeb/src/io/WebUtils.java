package io;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

public class WebUtils {
    public static String getYMD() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        String date = year + "/" + monthValue + "/" + dayOfMonth + "/";

        return date;
    }
}
