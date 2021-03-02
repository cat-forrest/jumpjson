/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson;

import com.alibaba.jumpjson.strategy.ScanService;

/**
 * @author yanhe
 * @version JSON.java, v 0.1 2021年02月28日 21:05 yanhe
 */
public class JSON extends ScanService {

    protected final String text;

    public JSON(String json) {
        this.text = json;
    }

    /**
     * 为了保证正确性，首先校验是否合法
     *
     * @param json
     * @return
     */
    public static JSONObject parseObject(String json) {
        JSONValidator from = JSONValidator.from(json);
        if (from.validate()) {
            return new JSONObject(json);
        } else {
            throw new RuntimeException("非法的json字符串");
        }
    }

}