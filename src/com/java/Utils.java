package com.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    /**
     * Форматирование Data в String<br><br>
     * Formatting Data into a String
     *
     * @param date
     * @return
     */
    public static String FormatData(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    /**
     * Делаем корректировку переменной типа String<br><br>
     * Making adjustments to a String variable
     *
     * @param text
     * @return
     */
    public static String CorrectVariableText(String text) {
        text = text.strip();
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isAlphabetic(text.charAt(i)) && text.charAt(i) != '-') {
                text = text.replace(text.charAt(i), '_');
            }
        }
        String firstPart = text.substring(0, 1).toUpperCase();
        String lastPart = text.substring(1).toLowerCase(Locale.ROOT);
        return firstPart + lastPart;
    }

    /**
     * Делаем корректировку переменной типа Data<br><br>
     * Making adjustments to a Data type variable
     *
     * @param date
     * @return
     */
    public static Date CorrectVariableData(Date date) {
        final Date DataNow = new Date();
        int year = 0;
        int month = 0;
        if (DataNow.getYear() - date.getYear() <= 0 || DataNow.getYear() - date.getYear() >= -2) {
            year = date.getYear() - 1900;
            month = date.getMonth() - 1;
        }
        return new Date(year, month, date.getDay());
    }
}
