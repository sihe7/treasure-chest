package com.hmh.string;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: Mr.hemenghao
 **/
public class sockerString {
    public static void main(String[] args) throws Exception {
        String strXml3 = "024000aa和一二三四和梦浩";

        Integer[] arr1 = {3, 4, 1, 16};
        String[] gbks = jiexi(strXml3, arr1, "GBK");
        for (String gbk : gbks) {
            System.out.println(gbk);
        }


    }

    public static String[] jiexi(String reps, Integer[] arr1, String biaa) {
        int length = arr1.length;
        String[] as = new String[length];
        try {
            byte[] aaa;
            int kk = 0;
            byte[] gbks = reps.getBytes(biaa);
            for (int i2 = 0; i2 < length; i2++) {
                aaa = new byte[arr1[i2]];
                int l = 0;
                for (int j = 0; j < arr1[i2]; j++) {
                    aaa[l] = gbks[kk];
                    l++;
                    kk++;
                }
                as[i2] = new String(aaa, "GBK");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return as;
    }
}
