/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson;

/**
 * @author yanhe
 * @version JSON.java, v 0.1 2021年02月28日 21:05 yanhe
 */
public class JSON {

    public JSON() {
    }

    private static String indexJson;

    /**
     * 为了保证正确性，首先校验是否合法
     *
     * @param json
     * @return
     */
    public static JSONObject parseObject(String json) {
        JSONValidator from = JSONValidator.from(json);
        if (from.validate()) {
            indexJson = json;
            return JSONObject.init();
        } else {
            throw new RuntimeException("非法的json字符串");
        }
    }

}