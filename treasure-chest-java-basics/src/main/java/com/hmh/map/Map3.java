package com.hmh.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022-07-06 10:18
 **/
public class Map3 {
    public static void main(String[] args) {
        System.out.println("==============================");
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("abc", 3);//put是往里放元素4
        map2.put("bit", 2);
        map2.put("hello", 4);
        Set<String> set = map2.keySet();//此时就把所有key=放在了set里
        System.out.println(set);//abc bit hello

        System.out.println("=============================");
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("abc", 3);
        map3.put("bit", 2);
        map3.put("bit", 4);
        map3.put(null, null);//用HashMap可以放null，但是用TreeMap不可以放null
        System.out.println(map3);
        Set<Map.Entry<String, Integer>> entrySet = map3.entrySet();//也就是在Set里，每个元素的类型是Map.Entry<String,Integer>
        for (Map.Entry<String, Integer> entry : entrySet) {//遍历Set
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("===============================");
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("s", "我是第一");
        treeMap.put("y", "我是第二");
        treeMap.put("a", "我是第三");
        treeMap.put("l", "我是第四");
        Set<Map.Entry<String, Object>> entries = treeMap.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
