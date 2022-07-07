package com.hmh.utils;



import org.apache.commons.lang3.time.DateUtils;

import java.util.Random;

/**
 * 序列号生成工具类
 */
public class SequenceUtil {

    /**
     * 获取28位流水号，格式：yyMMddHHmmssSS + 手机尾号 + 10位随机数
     * @param loginNo   手机号
     * @return          流水号
     */
    public static String getSerial(String loginNo) {
        String time = DateUtil.getCurrent("yyMMddHHmmssSS");
        return new StringBuilder(time).append(loginNo.substring(7, 11)).append(generateRandomWithNum(10)).toString();
    }

    /**
     * 获取29位交易流水号，格式：yyyyMMddHHmmssSS + 手机号 + 2位随机数
     * @param loginNo   手机号
     * @return          流水号
     */
    public static String generateTradeSeqNo(String loginNo) {
        String time = DateUtil.getCurrent(DateUtil.FULL_PATTERNS);
        return new StringBuilder(time).append(loginNo).append(generateRandomWithNum(2)).toString();
    }

    /**
     * 获取30位流水号，格式：yyyyMMddHHmmssSS + 手机尾号 + 10位随机数
     * @param loginNo   手机号
     * @return          流水号
     */
    public static String generateSeqNo(String loginNo) {
        String time = DateUtil.getCurrent(DateUtil.FULL_PATTERNS);
        return new StringBuilder(time).append(loginNo.substring(7, 11)).append(generateRandomWithNum(10)).toString();
    }

    /**
     * 获取31位流水号，格式：yyyyMMddHHmmssSS + 手机尾号 + 11位随机数
     * @param loginNo   手机号
     * @return          流水号
     */
    public static String generateSeqNum(String loginNo) {
        String time = DateUtil.getCurrent(DateUtil.FULL_PATTERNS);
        return new StringBuilder(time).append(loginNo.substring(7, 11)).append(generateRandomWithNum(11)).toString();
    }

    /**
     * 获取32位流水号，格式：yyyyMMddHHmmssSS + 手机尾号 + 12位随机数
     * @param loginNo   手机号
     * @return          流水号
     */
    public static String createSystemSeq(String loginNo) {
        String time = DateUtil.getCurrent(DateUtil.FULL_PATTERNS);
        return new StringBuilder(time).append(loginNo.substring(7, 11)).append(generateRandomWithNum(12)).toString();
    }

    /**
     * 获取32位流水号，格式：yyyyMMddHHmmssSS + 14位随机数
     * @return          流水号
     */
    public static String createSystemSeq() {
        String time = DateUtil.getCurrent(DateUtil.FULL_PATTERNS);
        return new StringBuilder(time).append(generateRandomWithNum(14)).toString();
    }
    /**
     * 获取20位流水号，格式：yyyyMMddHHmmssSS + n位随机数
     * @return          流水号
     */
    public static String createSerialNumber(int n) {
        String time = DateUtil.getCurrent(DateUtil.FULL_PATTERNS);
        return new StringBuilder(time).append(generateRandomWithNum(n-1)).toString();
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
