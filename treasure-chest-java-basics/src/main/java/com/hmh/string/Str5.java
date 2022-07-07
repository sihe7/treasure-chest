package com.hmh.string;


import com.alibaba.fastjson.JSON;
import com.hmh.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022-06-29 09:55
 **/
public class Str5 {
    public static void main(String[] args) {

        String responseMessage = null;
        if (!StringUtil.isEmpty(responseMessage)) {
            System.out.println("kong");
        }
        Map<String, String> respMsgMap = JSON.parseObject(responseMessage, Map.class);
        System.out.println(respMsgMap.get("ss"));
    }
}
