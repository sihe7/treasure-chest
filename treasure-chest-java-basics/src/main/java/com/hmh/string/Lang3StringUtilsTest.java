package com.hmh.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Mr.hemenghao
 * @description 探索org.apache.commons.lang3.StringUtils;这个工具类.
 * @date 2022-06-28 14:29
 **/
public class Lang3StringUtilsTest {
    public static void main(String[] args) {
        /**
         * StringUtils.isEmpty()
         * 是否为空. 可以看到 " " 空格是会绕过这种空判断,因为是一个空格,并不是严格的空值,会导致 isEmpty(" ")=false
         */
        System.out.println("StringUtils.isEmpty:    " + StringUtils.isEmpty(null));
        System.out.println("StringUtils.isEmpty:    " + StringUtils.isEmpty(""));
        System.out.println("StringUtils.isEmpty:    " + StringUtils.isEmpty(" "));
        System.out.println("StringUtils.isEmpty:    " + StringUtils.isEmpty("bob"));
        System.out.println("StringUtils.isEmpty:    " + StringUtils.isEmpty(" bob "));
        System.out.println("StringUtils.iNotsEmpty:    " + StringUtils.isNotEmpty(null));
        System.out.println("StringUtils.iNotsEmpty:    " + StringUtils.isNotEmpty("bob"));
        /**
         * StringUtils.isAnyEmpty()
         *
         * 是否有一个为空,只有一个为空,就为true.
         */
        System.out.println("StringUtils.isAnyEmpty: " + StringUtils.isAnyEmpty(null, null, "ss"));
        System.out.println("StringUtils.isAnyEmpty: " + StringUtils.isAnyEmpty(null, "foo"));
        System.out.println("StringUtils.isAnyEmpty: " + StringUtils.isAnyEmpty("", "bar"));
        System.out.println("StringUtils.isAnyEmpty: " + StringUtils.isAnyEmpty("bob", ""));
        System.out.println("StringUtils.isAnyEmpty: " + StringUtils.isAnyEmpty(" bob ", null));
        System.out.println("StringUtils.isAnyEmpty: " + StringUtils.isAnyEmpty(" ", "bar"));
        System.out.println("StringUtils.isAnyEmpty: " + StringUtils.isAnyEmpty("foo", "bar", null));
        /**
         * StringUtils.isNoneEmpty()
         * 相当于!isAnyEmpty(css) , 必须所有的值都不为空才返回true
         */


        /**
         * StringUtils.isBlank()
         * 是否为真空值(空格或者空值)
         */
        System.out.println("StringUtils.isBlank: " + StringUtils.isBlank(""));
        System.out.println("StringUtils.isBlank: " + StringUtils.isBlank(" "));
        System.out.println("StringUtils.isBlank: " + StringUtils.isBlank("bob"));
        System.out.println("StringUtils.isBlank: " + StringUtils.isBlank(" bob "));


        /**
         * StringUtils.isAnyBlank()
         *
         * 是否包含任何真空值(包含空格或空值)
         */
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank(null));
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank(null, "foo"));
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank(null, null));
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank("", "bar"));
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank("bob", ""));
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank(" bob ", null));
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank(" ", "bar"));
        System.out.println("StringUtils.isAnyBlank: " + StringUtils.isAnyBlank("foo", "bar"));

        /**
         * StringUtils.isNoneBlank()
         *
         * 是否全部都不包含空值或空格
         */
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank(null));
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank(null, "foo"));
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank(null, null));
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank("", "bar"));
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank("bob", ""));
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank(" bob ", null));
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank(" ", "bar"));
        System.out.println("StringUtils.isNoneBlank: " + StringUtils.isNoneBlank("foo", "bar"));
    }
}
