package com.hmh.string;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Mr.hemenghao
 **/
public class sockerString {
    public static void main(String[] args){
        String strXml3 = "024000aa  和一二三四和梦浩";
        Integer[] arr1 = {3, 4, 1, 18};
        String[] gbks = jiexi(strXml3, arr1, "GBK");
        for (String gbk : gbks) {
            System.out.println(gbk);
        }
        System.out.println("=======================");
        String strXml = "01400 和梦浩 23";
        String strXml2 = "01411 和梦浩 23";
        Integer[] arr3 = {3, 2, 7, 2};
        Integer[] arr4 = {3, 2, 7};
        List<String> gbk = assemblyArray(strXml2, arr3, "GBK", arr3.length);
        for (String s : gbk) {
            System.out.println("sss: " + s);
        }
    }

    public static String[] jiexi(String reps, Integer[] arr, String biaa) {
        int length = arr.length;
        String[] as = new String[length];
        try {
            byte[] aaa;
            int kk = 0;
            byte[] gbks = reps.getBytes(biaa);
            for (int i2 = 0; i2 < length; i2++) {
                aaa = new byte[arr[i2]];
                int l = 0;
                for (int j = 0; j < arr[i2]; j++) {
                    aaa[l] = gbks[kk];
                    l++;
                    kk++;
                }
                as[i2] = new String(aaa, "GBK").trim();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return as;
    }
    private static List<String> assemblyArray(String reps, Integer[] arr, String charset, Integer end) {
        int length = arr.length;
        List<String> as = new ArrayList<>();
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
                as.add(new String(reqByte, charset).trim());
            }
            if ("00".equals(as.get(1))) {
                for (int i = end; i < length; i++) {
                    reqByte = new byte[arr[i]];
                    int l = 0;
                    for (int j = l; j < arr[i]; j++) {
                        reqByte[l] = bytes[k];
                        l++;
                        k++;
                    }
                    as.add(new String(reqByte, charset).trim());
                }
            }
        } catch (Exception e) {
        }
        return as;
    }
}
