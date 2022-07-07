package com.hmh;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022-06-29 14:18
 **/
@SpringBootTest
public class StringTest {
    @Test
    public void strTest01(){
        System.out.println("|"+StringUtils.leftPad("", 2, " ")+"|");
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.size());
        if(list.size() == 0){
            System.out.println("list为空");
        }
        list.add("22");
        if(list.size() == 0){
            System.out.println("list为空");
        }
        System.out.println(list.size());
    }
    @Test
    public void strTest02(){
        String s = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)+StringUtils.leftPad("2", 8, '0');
        System.out.println(s);
        System.out.println(s.getBytes().length);
    }
    @Test
    public void strTest03(){
        long wtotalAmt = 0;
        long wtotalAmt1 = 0;
        int i = Integer.parseInt("000200");
        wtotalAmt += Integer.valueOf("000200");
        wtotalAmt1 += Integer.parseInt("000200");
        System.out.println(wtotalAmt);
        System.out.println(wtotalAmt1);
    }
    @Test
    public void strTest04() throws UnsupportedEncodingException {
        String gbk = new String("ftp://10.37.144.177/Bank_log/".getBytes("GBK"), "iso-8859-1");
        System.out.println(gbk);
        String gbk1 = new String(gbk.toString().getBytes("iso-8859-1"), "GBK");
        System.out.println(gbk1);
    }
}
