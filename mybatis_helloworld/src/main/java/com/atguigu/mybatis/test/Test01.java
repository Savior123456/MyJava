package com.atguigu.mybatis.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put(i+"",i+"");
        }
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry:
             entries) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }

    }
}
