package com.reusehive.utils;

public class UrlUtils {
    public static String getFileNameFromUrl(String url) {
        String[] split = url.split("/");
        return split[split.length - 1].split("\\.")[0];
    }
}
