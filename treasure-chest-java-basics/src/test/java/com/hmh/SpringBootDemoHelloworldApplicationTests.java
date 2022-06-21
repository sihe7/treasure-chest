package com.hmh;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 在使用 spring-test 的过程中，有两个 runner 可以选择，分别是 SpringRunner 和 SpringJUnit4ClassRunner。
 * 如果是在 4.3 之前，只能选择 SpringJUnit4ClassRunner，如果是 4.3 之后，建议选择 SpringRunner。
 * SpringRunner 对 junit 的版本有要求，需要 4.12 及以上。
 *
 * @RunWith(SpringJUnit4ClassRunner.class)使用了Spring的SpringJUnit4ClassRunner，以便在测试开始的时候自动创建Spring的应用上下文。
 *
 * 其他的想创建spring容器的话，就得在web.xml配置classloder。 注解了@RunWith就可以直接使用spring容器，直接使用@Test注解，不用启动spring容器
 *
 *
 *Springboot的@RunWith(SpringRunner.class)
 *
 * 注解的意义在于Test测试类要使用注入的类，比如@Autowired注入的类，
 *
 * 有了@RunWith(SpringRunner.class)这些类才能实例化到spring容器中，自动注入才能生效，
 *
 * 不然直接一个NullPointerExecption
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoHelloworldApplicationTests {

    @Test
    public void contextLoads() {

    }

}