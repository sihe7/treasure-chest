package com.hmh.list;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Mr.hemenghao
 **/
public class list1 {
    public static void main(String[] args) {

        String[] str = new String[]{ "yang", "guan", "bao" };
        List list = Arrays.asList(str);
        list.add("ss");
    }
}
