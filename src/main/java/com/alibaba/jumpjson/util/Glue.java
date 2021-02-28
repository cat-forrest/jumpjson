/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson.util;

/**
 * 胶水
 *
 * @author yanhe
 * @version Glue.java, v 0.1 2021年02月28日 19:12 yanhe
 */
public class Glue {

    public static String buildBeginNode(String key) {
        String begin = "\"" + key + "\":";
        return begin;
    }

    public static String buildEndNode() {

        return null;
    }

}