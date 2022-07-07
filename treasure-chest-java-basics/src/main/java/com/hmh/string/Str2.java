package com.hmh.string;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @description
 * @author Mr.hemenghao
 **/
public class Str2 {
    public static void main(String[] args) {
        System.out.println(createSerialNumber(4));
        System.out.println(createSystemSeq());

    }
    public static String createSerialNumber(int n) {
        String time = getCurrent("yyyyMMddHHmmssSS");
        return new StringBuilder(time).append(generateRandomWithNum(n)).toString();
    }
    public static String createSystemSeq() {
        String time =getCurrent("yyyyMMddHHmmssSS");
        return new StringBuilder(time).append(generateRandomWithNum(14)).toString();
    }
    public static String getCurrent(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        return format.format(calendar.getTime());
    }
    /**
     * 获取指定长度的随机数字符串
     * @param len    字符串长度
     * @return          随机数字符串
     */
    public static String generateRandomWithNum(int len) {
        final char[] nums = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            builder.append(nums[random.nextInt(nums.length)]);
        }
        return builder.toString();
    }
}
