/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson;

import com.alibaba.jumpjson.util.Glue;

/**
 * @author yanhe
 * @version JSONObject.java, v 0.1 2021年02月28日 18:57 yanhe
 */
public class JSONObject extends JSON {

    private JSONObject() {
    }

    public static JSONObject init() {
        return new JSONObject();
    }

    public String getString(String keyValue) {

        String start = Glue.buildBeginNode(keyValue);
        return null;
    }

}