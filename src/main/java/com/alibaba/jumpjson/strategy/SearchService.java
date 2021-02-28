/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanhe
 * @version SearchService.java, v 0.1 2021年02月28日 20:37 yanhe
 */
public abstract class SearchService {

    private final static Map<String, Object> box = new HashMap<>();

    static {
        box.put("\"", new StringSearcher());
    }

    public abstract int getStartIndex();

    public abstract int getEndIndex();

}