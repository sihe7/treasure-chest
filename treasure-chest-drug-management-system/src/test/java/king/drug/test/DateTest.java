package king.drug.test;

import king.drug.common.utils.DateUtil;
import king.drug.common.utils.StringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hemenghao
 * @date: 2022/4/13 13:30
 */
@SpringBootTest
public class DateTest {

    /**
     * 减号-
     */
    public static final String MINUS = "-";

    /**
     * 空字符串
     */
    public static final String EMPTY_STRING = "";
    @Test
    public void dateTest(){
        String date = DateUtil.getCurrent("yyyy-MM-dd HH24:mm:ss");
        System.out.println(date);
        String a= generateOrderNo();
        System.out.println(a);
    }
    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");
    public static String generateOrderNo(){
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if(SEQ.intValue()>9990){
            SEQ.getAndSet(1000);
        }
        return  dataTime.format(DF_FMT_PREFIX)+SEQ.getAndIncrement();
    }
    @Test
    public void dateTime02(){
        String s = DateUtil.dateFormat("202201023232".substring(0, 8));
        System.out.println(s);
    }

}
