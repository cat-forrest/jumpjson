/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson.strategy;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.jumpjson.util.Glue;

/**
 * @author yanhe
 * @version SearchService.java, v 0.1 2021年02月28日 20:37 yanhe
 */
public abstract class ScanService {

    //private ScanService() {
    //
    //}

    private final static Map<String, Object> box = new HashMap<>();

    static {
        box.put("\"", new StringSearcher());
    }

    public int getStartIndex(String json, String key) {
        Glue.buildBeginNode(key);
        return 0;
    }

    public int getEndIndex() {
        return 0;
    }

    //public getString()

}