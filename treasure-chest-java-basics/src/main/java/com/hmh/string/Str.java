package com.hmh.string;

import sun.nio.cs.ext.GBK;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @description:
 * @author: Mr.hemenghao
 **/
public class Str {
    public static void main(String[] args) throws Exception {
        String respStr = "aaa123失败";
        System.out.println("字符长度"+respStr.length());
        System.out.println("UTF-8字节长度"+respStr.getBytes().length);
        System.out.println("GBK字节长度"+respStr.getBytes("GBK").length);
        int[] arr = {1,2,3,2};
        String[] repData = new String[arr.length];
        int k = 0;
        for (int i = 0; i < 4; i++) {
            repData[i] = respStr.substring(k, k + arr[i]).trim();
            k += arr[i];
        }
        System.out.println(repData[3]);
        System.out.println("==========================");
        try {
            String utf="name和";
            System.out.println("UTF-8长度: "+utf.getBytes().length);
            System.out.println("UTF-8: "+utf);
            String gbk= URLEncoder.encode(utf,"GBK");
            System.out.println("GBK长度: "+utf.getBytes("GBK").length);
            System.out.println("GBK: "+utf);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("=================");
        String strXml = "000aaa和梦浩";
        byte[] utfBuffer = strXml.getBytes();
        System.out.println("字符长度"+utfBuffer.length);
        for (byte b : utfBuffer) {
            System.out.println(b);
        }
        byte[] gbkBuffer = strXml.getBytes("GBK");
        System.out.println("字符长度"+gbkBuffer.length);
        for (byte b : gbkBuffer) {
            System.out.println(b);
        }
        System.out.println("=====================");
        byte[] a = {97};
        byte[] b = {-70,-58};
        byte[] c = {-26,-75,-87};
        String s = String.valueOf(a);
        String res = new String(a);
        System.out.println(s);
        System.out.println(res);
        String s1 = String.valueOf(b);
        String res1 = new String(b);
        String res3 = new String(c);
        String res2 = new String(b, "GBK");
        System.out.println(s1);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println("===================");
        String o = "00033";
        int i = Integer.parseInt(o);
        System.out.println(i);
        System.out.println("=======================");
        String strXml1 = "000aaa和梦浩";
        char[] chars = strXml1.toCharArray();
        System.out.println(strXml1.charAt(7));
        for (char aChar : chars) {
            System.out.println(aChar);
        }
        System.out.println("============二维数组解析============");
        String strXml3 = "024000aa和一二三四和梦浩";
        byte[] gbks = strXml3.getBytes("GBK");
        System.out.println("字节第一位: "+ gbks[0]);
        System.out.println(strXml3.getBytes("GBK").length);
        int[] arr1 = {3, 4, 1, 16};
        byte[] aaa ;
        int kk = 0;
        String[] as = new String[arr1.length];
        for (int i2 = 0; i2 < arr1.length; i2++) {
            aaa= new byte[arr1[i2]];
            int l= 0;
            for (int j = 0; j< arr1[i2]; j++){
                aaa[l] = gbks[kk];
                l++;
                kk ++;
            }
            as[i2] = new String(aaa, "GBK");
        }
        for (String a1 : as) {
            System.out.println("sss:    "+a1);
        }


    }


}
