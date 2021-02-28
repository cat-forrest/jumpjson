/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.alibaba.jumpjson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author yanhe
 * @version MainTest.java, v 0.1 2021年02月28日 16:14 yanhe
 */
public class MainTest {
    public static void main(String[] args) {

        String bigjson = readJsonFile("/Users/yanhe/Downloads/bigjson.txt");
        long begin = System.currentTimeMillis();
        System.out.println("开始~~~~~~~" + begin);
        JSONValidator from = JSONValidator.from(bigjson);
        boolean validate = from.validate();
        long end = System.currentTimeMillis();
        long res = end - begin;
        System.out.println(validate + "~~~~~结束~~~~~~~" + res);
        JSONObject.parseObject(bigjson);
        JSON.parseObject(bigjson);

    }


    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}