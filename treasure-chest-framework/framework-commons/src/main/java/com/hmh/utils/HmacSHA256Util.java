package com.hmh.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * @Description HmacSHA256算法
 */
@Slf4j
public class HmacSHA256Util {

    /**
     * HmacSHA256算法,返回的结果始终是32位
     * @param key 加密的键，可以是任何数据
     * @param content 待加密的内容
     * @return 加密后的内容
     * @throws Exception
     */
    public static byte[] hmacSHA256(byte[] key,byte[] content) throws Exception {
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        hmacSha256.init(new SecretKeySpec(key, 0, key.length, "HmacSHA256"));
        byte[] hmacSha256Bytes = hmacSha256.doFinal(content);
        return hmacSha256Bytes;
    }

    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    public  static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }
    /**
     * sha256_HMAC加密
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public static String hmacSHA256( String message,String secret) throws Exception {
        String hash = "";
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        hmacSha256.init(secret_key);
        byte[] bytes = hmacSha256.doFinal(message.getBytes());
        hash = byteArrayToHexString(bytes);
        return hash;
    }
    public static void main(String[] args) {
        try {
            Map<String,Object> map1 = new HashMap<>();
            map1.put("method","jujie.hub.common.orderSubmit");
            map1.put("peerId",100012);
            Map<String,Object> map2 = new HashMap<>();
            map2.put("amount",1);
            map2.put("phoneNo","19921612903");
            Map<String,Object> map3 = new HashMap<>();
            map3.put("head",map1);
            map3.put("bizParams",map2);
            String requestJson = JSONObject.toJSONString(map3);
            JSONObject jsonObject = JSONObject.parseObject(requestJson);
            JSONObject jsonObject1 = getSortJson(jsonObject);
            System.out.println(jsonObject1.toJSONString());
            ObjectMapper mapper=new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonObject1.toJSONString());
            System.out.println(jsonNode.toString());
            String strToSign = jsonNodeToSignString(jsonNode);
            System.out.println(strToSign);
            //return hmacSHA256(strToSign, appSecret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getSortJson(JSONObject json) {
        if (Objects.isNull(json)) {
            return new JSONObject();
        }
        Set<String> keySet = json.keySet();
        SortedMap<String, Object> map = new TreeMap<>();
        for (String key:keySet) {
            Object value = json.get(key);
            if (Objects.nonNull(value) && value instanceof JSONArray) {
                JSONArray array = json.getJSONArray(key);
                JSONArray jsonArray = new JSONArray(new LinkedList<>());
                for (int i=0;i<array.size();i++) {
                    JSONObject sortJson = getSortJson(array.getJSONObject(i));
                    jsonArray.add(sortJson);
                }
                map.put(key, jsonArray);
            } else if (Objects.nonNull(value) && value instanceof JSONObject) {
                JSONObject sortJson = getSortJson(json.getJSONObject(key));
                map.put(key, sortJson);
            } else {
                map.put(key, value);
            }
        }
        return new JSONObject(map);
    }




    public static String jsonNodeToSignString(JsonNode jsonNode) {

        String str = "";

        Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();
        while (iterator.hasNext()) {

            Map.Entry entry = iterator.next();
            JsonNode subNode = (JsonNode) entry.getValue();

            if (!StringUtils.isEmpty(str)&&!subNode.isNull()) {
                str += ",";
            }
            if (subNode.isTextual()) {
                str += entry.getKey() + "=" + subNode.asText();
            }else if (subNode.isNumber()) {
                str += entry.getKey() + "=" + subNode.asText();
            }else if (subNode.isNull()) {
                continue;
            }
            else if (subNode.isBoolean()) {
                str += entry.getKey() + "=" + subNode.asBoolean();
            } else if (subNode.isArray()) {

                str += entry.getKey() + "=[";

                String arrayStr ="";
                for (JsonNode objNode : subNode) {
                    if (!StringUtils.isEmpty(arrayStr)) {
                        arrayStr += ",";
                    }
                    arrayStr +="{"+ (jsonNodeToSignString(objNode))+"}";
                }
                str +=arrayStr+ "]";
            } else {
                str += entry.getKey() + "={";
                str += (jsonNodeToSignString(subNode));
                str += "}";
            }


        }

        return str;

    }

    /**
     * HmacSHA256获取签名
     * @param requestHashMap 请求map
     * @param appSecret 秘钥
     * @return 返回签名
     * @throws Exception
     */
    public static String getSign(Map<Object, Object> requestHashMap, String appSecret) throws Exception {
        String requestJson = JSONObject.toJSONString(requestHashMap);
        JSONObject jsonObject = getSortJson(JSONObject.parseObject(requestJson));
        ObjectMapper mapper=new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonObject.toJSONString());
        String strToSign = jsonNodeToSignString(jsonNode);
        return hmacSHA256(strToSign, appSecret);
    }


    /**
     * HmacSHA256验签
     * @param verifyMap 结果map
     * @param sign 响应签名
     * @param appSecret 秘钥
     * @return
     * @throws Exception
     */
    public static boolean checkSign(Map<Object, Object> verifyMap, String sign, String appSecret) throws Exception {
        //true：校验成功
        String getSign = getSign(verifyMap, appSecret);
        return getSign != null && sign.equals(getSign);
    }
}

