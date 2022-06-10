package king.drug.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import king.drug.common.utils.JsonUtil;
import king.drug.pojo.JsonTestbean;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * Json测试类
 *
 * @author: hemenghao
 * @date: 2022/4/14 21:46
 */
@SpringBootTest
public class jsonTest {
    @Test
    public void jsonTest01() {
        HashMap<Object, Object> headMap = new HashMap<>();
        HashMap<Object, Object> bizMap = new HashMap<>();
        HashMap<Object, Object> map = new HashMap<>();
        headMap.put("method", "com.hmh.king");
        headMap.put("version", "4.0");
        bizMap.put("code", 100);
        bizMap.put("msg", "成功");
        map.put("head", headMap);
        map.put("biz", bizMap);
        String jsonString = JSONObject.toJSONString(map);
        System.out.println("map转化为字符串:" + jsonString);
        JsonTestbean bean = JsonUtil.jsonByBean(jsonString, JsonTestbean.class);
        System.out.println("json转化为对象:" + bean);
        String beanJson = JSONObject.toJSONString(bean);
        System.out.println("对象转化为json" + beanJson);
    }

    @Test
    public void jsonTest02() {
        HashMap<Object, Object> headMap = new HashMap<>();
        HashMap<Object, Object> bizMap = new HashMap<>();
        HashMap<Object, Object> map = new HashMap<>();
        headMap.put("method", "com.hmh.king");
        headMap.put("version", "4.0");
        bizMap.put("msg", "成功");
        map.put("head", headMap);
        map.put("biz", bizMap);
        String jsonString = JSONObject.toJSONString(map);
        System.out.println("map转化为字符串:" + jsonString);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        String biz = jsonObject.getString("biz");
        JSONObject jsonObject1 = JSONObject.parseObject(biz);
        Object code = jsonObject1.get("code");
        System.out.println("code是否为空" + code);
        JsonTestbean bean = JsonUtil.jsonByBean(jsonString, JsonTestbean.class);
        System.out.println("json转化为对象:" + bean);
        String beanJson = JSONObject.toJSONString(bean);
        System.out.println("对象转化为json" + beanJson);
    }

    @Test
    public void jsonTest03() {
        HashMap<Object, Object> headMap = new HashMap<>();
        HashMap<Object, Object> bizMap = new HashMap<>();
        HashMap<Object, Object> map = new HashMap<>();
        headMap.put("method", "com.hmh.king");
        headMap.put("version", "4.0");
        bizMap.put("msg", "成功");
        map.put("head", headMap);
        map.put("biz", bizMap);
        String jsonString = JSONObject.toJSONString(map);
        System.out.println("map转化为字符串:" + jsonString);
        //json可以直接转换为map
        Map<String, Object> objectMap = JSON.parseObject(jsonString);
        System.out.println("json可以直接转换为map打印:" + objectMap);
        String jsonString1 = JSONObject.toJSONString(objectMap);
        System.out.println("objectMap转化为字符串:" + jsonString1);
        Set<String> strings = objectMap.keySet();


        for (String string : strings) {
            System.out.println(string);
            System.out.println("map的键：" + objectMap.get(string));
        }
        for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

    @Test
    public void jsonTest04() {
        String str = StringUtils.join(new String[]{"cat", "dog", "carrot", "leaf", "door"}, ":");
        System.out.println(str);
    }

    @Test
    public void jsonTest05() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", "1");
        String q = JSONObject.toJSONString(map);
        JSONObject jsonObject = JSONObject.parseObject(q);
        System.out.println("jsonObject为空" + jsonObject);
        if(Objects.isNull(jsonObject) || !"0".equals(jsonObject.get("code"))){
            System.out.println("打印则没异常");
        }
    }
}
