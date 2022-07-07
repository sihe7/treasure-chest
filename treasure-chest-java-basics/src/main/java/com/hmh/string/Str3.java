package com.hmh.string;

import java.io.File;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022/06/23
 **/
public class Str3 {
    public static void main(String[] args) {
        String filePath = "E:/1/jpg";
        int i = filePath.lastIndexOf(File.separator);
        System.out.println(i);
    }
}
