package king.drug.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: hemenghao
 * @date: 2022/5/5 17:13
 */
@SpringBootTest
public class TimeTest {
    @Test
    public void timeTest01(){
        long l = System.currentTimeMillis();
        System.out.println(l);
    }
}
