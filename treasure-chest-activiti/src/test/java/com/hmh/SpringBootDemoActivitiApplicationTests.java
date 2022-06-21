package com.hmh;

import com.hmh.util.SecurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoActivitiApplicationTests {

    //Activiti7 提供了两个新的API ProcessRuntime和TaskRuntime，
    // 但是这两个API必须使用Spring Security，这对于项目没有引入Spring Security是非常不友好的。
    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private SecurityUtil securityUtil;

    @Test
    public void contextLoads() {
        //获取当前现场的登录用户
        securityUtil.logInAs("erdemedeiros");
        //获取当前用户任务
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println("activiti开始");
        //循环打印出用户任务信息
        processDefinitionPage.getContent().forEach(System.out::println);
        System.out.println("activiti结束");
    }

}

