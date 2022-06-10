package king.drug.test;

import king.drug.common.utils.http.HttpUtils;
import king.drug.common.utils.http.OkHttpKit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hemenghao
 * @date: 2022/5/12 12:34
 */
@SpringBootTest
public class HttpTest {
    @Test
    public void httpTest01() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("showapi_appid","967297");
        map.put("showapi_sign","e51adf413c5e4554ac5f4da5289f17b6");
        String url = "https://route.showapi.com/1832-1";
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> sb.append("&").append(k).append("=").append(v.toString()));
        if (!url.contains("?")) {
            // url不包含?
            sb.deleteCharAt(0).insert(0, "?");
        }
        System.out.println("StringBUilder:" + sb);
        String s = HttpUtils.sendPost(url, sb.toString());
        System.out.println(s);
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        String execute = OkHttpKit.post(url).parameters(map).execute();
        System.out.println(execute);
    }
}
