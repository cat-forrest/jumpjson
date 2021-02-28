/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson.error;

/**
 * @author yanhe
 * @version JsonException.java, v 0.1 2021年02月28日 15:24 yanhe
 */
public class JSONException extends RuntimeException {

    public JSONException() {
        super();
    }

    public JSONException(String message) {
        super(message);
    }

    public JSONException(String message, Throwable cause) {
        super(message, cause);
    }

}