package com.hmh.string;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022-06-28 16:39
 **/
public class JsharzlTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String respStr = "0002181313001906608          001*01818678                                                  淮安黄河路黄河花园11块地4B栋*213                                                                    021200000000000000000000000";
        Integer[] arr = {6, 3, 20, 2, 60, 100, 4, 10, 10};
        List<String> arrayList = assemblyArray(respStr, arr, "GBK", 4);
        Integer i = 0;
        for (String s : arrayList) {
            System.out.println(i++ + " " + s);
        }

        System.out.println("======================");
        String rr = "0000311333001894101          24";
        Integer[] arr1 = {6, 3, 20, 2, 60, 100, 4};
        List<String> list = assemblyArray(rr, arr1, "GBK", 4);
        Integer j = 0;
        for (String s : list) {
            System.out.println(j++ + " " + s);
        }
        // 获取返回报文总字节数，有异常
        Integer totalBytes = rr.getBytes("GBK").length;
        System.out.println("总字节数:" + totalBytes);
        // 返回有效字节总数(6)
        Integer effectBytes = Integer.parseInt(list.get(0));
        System.out.println("总字节数2:" + effectBytes);
        if (!effectBytes.equals(totalBytes)) {
            System.out.println("有误");
        }
    }

    private static List<String> assemblyArray(String reps, Integer[] arr, String charset, Integer end) {
        int length = arr.length;
        List<String> list = new ArrayList<>();
        try {
            byte[] reqByte;
            int k = 0;
            byte[] bytes = reps.getBytes(charset);
            for (int i = 0; i < end; i++) {
                reqByte = new byte[arr[i]];
                int l = 0;
                for (int j = 0; j < arr[i]; j++) {
                    reqByte[l] = bytes[k];
                    l++;
                    k++;
                }
                list.add(new String(reqByte, charset).trim());
            }
            if ("00".equals(list.get(3))) {
                for (int i = end; i < length; i++) {
                    reqByte = new byte[arr[i]];
                    int l = 0;
                    for (int j = l; j < arr[i]; j++) {
                        reqByte[l] = bytes[k];
                        l++;
                        k++;
                    }
                    list.add(new String(reqByte, charset).trim());
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }
}
