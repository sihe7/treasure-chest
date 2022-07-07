package com.hmh;

import com.hmh.utils.TraceLogIdUtil;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Mr.hemenghao
 * @description
 * @date 2022-07-04 14:23
 **/
public class TraceLogIdUtilTest {
    @Test
    public void  test01(){
        System.out.println(TraceLogIdUtil.getOrGenerateLogId());
    }

}
