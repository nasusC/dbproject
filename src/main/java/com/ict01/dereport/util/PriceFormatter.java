package com.ict01.dereport.util;

import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormatter {
    public static String formatPrice(int price) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(price);
    }
}

