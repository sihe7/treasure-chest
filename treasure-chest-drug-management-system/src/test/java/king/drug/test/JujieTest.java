package king.drug.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import king.drug.api.dtores.nameDTO;
import king.drug.common.utils.DateUtil;
import king.drug.common.utils.HmacSHA256Util;
import king.drug.common.utils.StringUtil;
import king.drug.common.utils.http.OkHttpKit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 聚杰接口相关测试
 *
 * @author: hemenghao
 * @date: 2022/4/11 22:35
 */
@SpringBootTest
public class JujieTest {

    @Test
    public void aa() throws Exception {
        String URL = "http://dev.jujienet.com:19958/hub/common/api/100110";
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name", "1");
        map1.put("age", "11");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("2", "2");
        map2.put("3", "3");
        map2.put("4", "4");
        HashMap<String, Map> map = new HashMap<>();
        map.put("head", map1);
        map.put("diz", map2);
        String jsonString = JSONObject.toJSONString(map);
        System.out.println("hemenghao " + jsonString);
        JSONObject object = JSONObject.parseObject(jsonString);
        nameDTO dto = new nameDTO();
        Object head = object.get("head");
        nameDTO nameDTO = JSONObject.parseObject(head.toString(), nameDTO.class);
        System.out.println("4444:" + object.get("head"));
        System.out.println("nameDTO.getName:" + nameDTO.getName());

        //组装请求众安网关的参数
        Map<String, String> gateMap = new HashMap<>();
        gateMap.put("signType", "RSA");
        gateMap.put("format", "JSON");
        gateMap.put("charset", "UTF-8");
        gateMap.put("timestamp", DateUtil.getCurrent(DateUtil.SETTLE_PATTERN));
        gateMap.put("version", "1.0.0");
        String gate = JSONObject.toJSONString(gateMap);
        System.out.println(gate);
        String s = OkHttpKit.post(URL)
                .header("peerId", "200001")
                .header("method", "jujie.hub.common.auth")
                .header("requestTime", "2019-12-01 15:32:03")
                .header("transactionId", "288328781787382")
                .header("version", "2.0")
                .header("sign", "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08")
                .parameter("outOrderId", "2019030100099991")
                .parameter("templateId", "200000001")
                .execute();
        System.out.println("xiangyinjiegou1dayin:" + s);
        JSONObject resultObject = JSONObject.parseObject(s);
        System.out.println(resultObject);
        System.out.println("11:" + resultObject.get("head"));
        System.out.println("==================================");
        HashMap<Object, Object> headHashMap = new HashMap<>();
        HashMap<Object, Object> bizHashMap = new HashMap<>();
        HashMap<String, String> requestHashMap = new HashMap<>();
        headHashMap.put("peerId", "200001");
        headHashMap.put("method", "jujie.hub.common.auth");
        headHashMap.put("requestTime", "2019-12-01 15:32:03");
        headHashMap.put("transactionId", "288328781787382");
        headHashMap.put("version", "2.0");
        headHashMap.put("sign", "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08");
        bizHashMap.put("outOrderId", "2019030100099991");
        bizHashMap.put("templateId", "200000001");
        requestHashMap.put("head", headHashMap.toString());
        requestHashMap.put("biz", bizHashMap.toString());
        String request = JSONObject.toJSONString(requestHashMap);
        String execute = OkHttpKit.post(URL).json(request).execute();
        System.out.println("响应结果返回： " + execute);

        System.out.println("=====================");
        /**
         * json->转化为JSonNode
         */
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(execute);
        Iterator<String> keys = jsonNode.fieldNames();
        while (keys.hasNext()) {
            String fieldName = keys.next();
            System.out.println(fieldName + ": " + jsonNode.path(fieldName).toString());
        }
        System.out.println("===============");
        System.out.println(jsonNode);
        String strToSign = jsonNodeToSignString(jsonNode);
        System.out.println("nodeToSignString:" + strToSign);
        String appSecret = "12345678906";
        String sign = HmacSHA256Util.hmacSHA256(strToSign, appSecret);
        //JsonNode ----> JSON
        System.out.println(mapper.writeValueAsString(jsonNode));
        System.out.println("sign" + sign);
        String toJSON = JSONObject.toJSONString(map);
    }


    @Test
    public void mapTest01() throws JsonProcessingException {
        HashMap<Object, Object> headMap = new HashMap<>();
        HashMap<Object, Object> bizMap = new HashMap<>();
        HashMap<Object, Object> map = new HashMap<>();
        headMap.put("method", "main");
        headMap.put("verion", "4.0");
        bizMap.put("name", "和梦浩");
        map.put("haed", headMap);
        map.put("bizparams", bizMap);
        String toJSON = JSONObject.toJSONString(map);
        System.out.println("插入date之前的map:" + toJSON);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(toJSON);
        String signString = jsonNodeToSignString(jsonNode);
        System.out.println("map之前签名node:" + signString);
        System.out.println("================");
        bizMap.put("date", DateUtil.getCurrentDate());
        String toJSON1 = JSONObject.toJSONString(map);
        System.out.println("插入date之前的map:" + toJSON1);
        ObjectMapper mapper1 = new ObjectMapper();
        JsonNode jsonNode1 = mapper1.readTree(toJSON1);
        String signString1 = jsonNodeToSignString(jsonNode1);
        System.out.println("map之后签名node:" + signString1);

    }

    /**
     * 聚杰签名生成
     *
     * @param jsonNode
     * @return
     */
    public static String jsonNodeToSignString(JsonNode jsonNode) {

        String str = "";

        Iterator<Map.Entry<String, JsonNode>> iterator = jsonNode.fields();
        while (iterator.hasNext()) {

            Map.Entry entry = iterator.next();
            JsonNode subNode = (JsonNode) entry.getValue();

            if (!StringUtil.isEmpty(str) && !subNode.isNull()) {
                str += ",";
            }
            if (subNode.isTextual()) {
                str += entry.getKey() + "=" + subNode.asText();
            } else if (subNode.isNumber()) {
                str += entry.getKey() + "=" + subNode.asText();
            } else if (subNode.isNull()) {
                continue;
            } else if (subNode.isBoolean()) {
                str += entry.getKey() + "=" + subNode.asBoolean();
            } else if (subNode.isArray()) {

                str += entry.getKey() + "=[";

                String arrayStr = "";
                for (JsonNode objNode : subNode) {
                    if (!StringUtil.isEmpty(arrayStr)) {
                        arrayStr += ",";
                    }
                    arrayStr += "{" + (jsonNodeToSignString(objNode)) + "}";
                }
                str += arrayStr + "]";
            } else {
                str += entry.getKey() + "={";
                str += (jsonNodeToSignString(subNode));
                str += "}";
            }


        }

        return str;

    }
    @Test
    public void testMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("d", 10);
        Object b = map.get("c");
        System.out.println(b);
    }
//打印结果是：null。
@Test
public void testJSONObject() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("d", 10);
    JSONObject jSONObject = JSONObject.parseObject(JSON.toJSONString(map));
    int xx = jSONObject.getIntValue("d");
    System.out.println(xx);
    // 从jSONObject中用get(Object key)方法取出不存在的键值对时不会报异常，会返回null
    Object y = jSONObject.getIntValue("dd");
    System.out.println(y);
    // 从jSONObject中用getxxx(String key)方法取出不存在的键值对时报异常
    String y2 = jSONObject.getString("dd");
    System.out.println(y2);
}
}
