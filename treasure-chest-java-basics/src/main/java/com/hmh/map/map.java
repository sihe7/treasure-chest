package com.hmh.map;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mr.hemenghao
 **/
public class map {
    public static void main(String[] args) {
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        // 生成的 map 集合中只有一个键值对：{version=6.28}
        Map<String, Double> map = pairArrayList.stream()
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

        String[] departments = new String[]{"RDC", "RDC", "KKB"};
        // 抛出 IllegalStateException 异常
        Map<Integer, String> map1 = Arrays.stream(departments)
                .collect(Collectors.toMap(String::hashCode, str -> str));



    }
}
