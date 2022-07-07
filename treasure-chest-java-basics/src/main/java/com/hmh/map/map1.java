package com.hmh.map;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022-06-24 09:43
 **/
public class map1 {
    public static void main(String[] args) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(objectObjectHashMap.get("hem"));
        String s = StringUtils.leftPad(null, 10, "8");
        System.out.println(s);

    }
}
