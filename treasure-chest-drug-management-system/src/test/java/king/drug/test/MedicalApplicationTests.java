package king.drug.test;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import king.drug.api.dtores.nameDTO;
import king.drug.common.utils.DateUtil;
import king.drug.common.utils.HmacSHA256Util;
import king.drug.common.utils.StringUtil;
import king.drug.common.utils.http.OkHttpKit;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.UriAssert;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.*;

/**
 * 药品管理相关测试
 */
@SpringBootTest
public class MedicalApplicationTests {

    @Test
    public void contextLoads() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "和");
        map.put("age", "22");
        Set<Map.Entry<String, String>> set = map.entrySet();
        System.out.println(set);
        if(null != set){
            Iterator<Map.Entry<String, String>> iterator = set.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> entry = iterator.next();
                entry.setValue("SS");
                String value = entry.getValue();
                String key = entry.getKey();

                System.out.println("key" + key);
                System.out.println("vale" + value);
            }
        }
    }
    @Test
    public void urlConvertorTest(){
        String url = "https://api.cloud.189.cn/open/oauth2/ssoH5.action?appKey=1130131080901&appSignature=E68FD6CB38F34BA4EDEE906699052DC90463F773&timestamp=1648001385155&accessToken=A5AAA0ADF9C49686B3E0561866BB654D";
        String convertor = urlConvertor(url);
        System.out.println(convertor);
    }

    /**
     * 转换方法
     * @param url .
     * @return .
     */
    public static String urlConvertor(String url){
        String newUrl = url;
        if(!StringUtils.isEmpty(url)){
            String[] codeArray = new String[]{"&quot;","&amp;","&lt;","&gt;"};
            String[] codeContextArray = new String[]{"\"","&","<",">"};

            for (int i = 0; i < codeArray.length; i++) {
                newUrl = newUrl.replace(codeArray[i], codeContextArray[i]);
            }
        }
        return newUrl;
    }

    @Test
    public void bbb(){
        String str = "{\n" +
                "\"head\": {\n" +
                "\t\t\"peerId\": \"200001\",\n" +
                "\"method\": \"jujie.hub.common.auth\",\n" +
                "\"status\": \"0000\",\n" +
                "        \"responseTime\": \"2017-08-29 15:32:23\",\n" +
                "\"transactionId\": \"288328781787382\",\n" +
                "\"sign\": \"9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08\"\n" +
                "    },\n" +
                "    \"biz\": {\n" +
                "        \"url\": \"https://XXXXX/XXX\"\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        Set<String> strings = jsonObject.keySet();
        Iterator<String> iterator = strings.iterator();
    }

}
