package king.drug.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: hemenghao
 * @date: 2022/4/24 11:41
 */
@SpringBootTest
public class javaBeanTest {
    private String name = "和梦浩";
    @Test
    public void c(){
        a();
        b();
        System.out.println(name);
    }
    void a(){
        name = "a";
    }
    void b(){
        name = "b";
    }
    @Test
    public void bb(){
        System.out.println(name);
    }

}
