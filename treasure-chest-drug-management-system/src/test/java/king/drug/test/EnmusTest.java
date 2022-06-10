package king.drug.test;

import com.jayway.jsonpath.internal.function.json.Append;
import king.drug.enums.Apple;
import king.drug.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 枚举类型测试
 * @author: hemenghao
 * @date: 2022/4/13 12:45
 */
@SpringBootTest
public class EnmusTest {
    @Test
    public void enumTest01(){
        String a = Apple.INSTANCE.getMethod();
        System.out.println(a);
        User user = new User();
        System.out.println(user.getA());
    }
}
