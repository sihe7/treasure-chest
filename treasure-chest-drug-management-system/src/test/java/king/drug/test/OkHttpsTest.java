package king.drug.test;

import com.ejlchina.okhttps.HTTP;
import king.drug.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * OkHttpsTest
 * @author: hemenghao
 * @date: 2022/4/11 22:35
 */
@SpringBootTest
public class OkHttpsTest {

    private static final String URL = "http[s]://route.showapi.com/1832-1?showapi_appid=替换自己的值&showapi_sign=替换自己的值";
    private static final String showapi_appid = "967297";
    private static final String showapi_sign = "e51adf413c5e4554ac5f4da5289f17b6";
    @Test
    public void httpTest01(){
        HTTP http = HTTP.builder().build();
    }
    @Test
    public void httpTest02(){

    }
}
