package com.hmh;


import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * @description: thymeleaf测试类
 * @author: Mr.hemenghao
 **/
@SpringBootTest
public class thymeleafTest {
    @Autowired
    TemplateEngine templateEngine;
    /**
     * 通过‘th:’前缀来锁定要替换的值，就是这里的‘helloWorld’内容。 但是这个数据是写死的，下面我们将数据动态地呈现在页面上。
     */
    @Test
    public void thyTest01(){
            // 创建模板引擎
            TemplateEngine engine = new TemplateEngine();
            // 准备模板
            String input = "<input type='text' th:value='helloWorld'/>";
            // 准备数据
            Context context = new Context();
            // 调用引擎，处理模板和数据
            String result = engine.process(input, context);
            System.out.println("模板渲染结果==> " + result);

    }
    /**
     * 通过‘th:’前缀来锁定要替换的值，就是这里的‘helloWorld’内容。 但是这个数据是写死的，下面我们将数据动态地呈现在页面上。
     */
    @Test
    public void test1() {
        // 创建模板引擎
        TemplateEngine engine = new TemplateEngine();
        // 准备模板
        String input = "<input type='text' th:value='${name}'/>";
        // 准备数据
        Context context = new Context();
        context.setVariable("name", "李四");
        // 处理模板和数据
        String result = engine.process(input, context);
        System.out.println("模板渲染结果==> " + result);
    }

    /**
     * 获取/resources/templates下的index.html文件
     */
    @Test
    public void test2() {
        // 创建模板引擎
        TemplateEngine engine = new TemplateEngine();
        // 读取模板文件（在类路径下找要渲染的模板）
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        // 设置引擎使用 resolver
        engine.setTemplateResolver(resolver);
        // 指定数据
        Context context = new Context();
        context.setVariable("name", "李四");
        // 处理模板（注：文件名后缀不能省）
        String result = engine.process("index.html", context);
        System.out.println("模板文件渲染结果==> " + result);
    }

    /**
     * 获取templates/main2.html,生成字符串
     */
    @Test
    public void test3() {
        TemplateEngine engine = new TemplateEngine();

        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        // 在类路径下的templates目录找后缀为html的main文件
        //application.yml里面已经配置
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        engine.setTemplateResolver(resolver);

        Context context = new Context();
        context.setVariable("name", "张三");

        String result = engine.process("main2", context);
        System.out.println("模板文件渲染结果==> " + result);
    }

    /**
     * 渲染时，我们需要首先注入一个 TemplateEngine 对象，
     * 这个对象就是在 Thymeleaf 的自动化配置类中配置的（即当我们引入 Thymeleaf 的依赖之后，这个实例就有了）。
     * 然后构造一个 Context 对象用来存放变量。
     * 调用 process 方法进行渲染，该方法的返回值就是渲染后的 HTML 字符串，然后我们将这个字符串发送出去。
     */
    @Test
    public void test4(){
        Context context = new Context();
        context.setVariable("username", "javaboy");
        context.setVariable("position", "Java工程师");
        context.setVariable("salary", 99999);
        String mail = templateEngine.process("youxiang", context);
        System.out.println("模板文件渲染结果==> " + mail);
        //省略邮件发送
    }
}
