package com.hmh;

import com.hmh.bean.Student;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Mr.hemenghao
 **/
@SpringBootTest
public class freemarkerTest {
    /**
     * 1、根据模板文件生成html文件
     * @throws IOException
     * @throws TemplateException
     */
    @Test
    public void test01() throws IOException, TemplateException {
        //1. 创建配置类信息-(小版本适配)
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);

        //2. 对配置类进行配置
        String path = this.getClass().getResource("/templates/").getPath();
        configuration.setDirectoryForTemplateLoading(new File(path));
        configuration.setDefaultEncoding("utf-8");

        //3. 获取模板文件对象
        Template template = configuration.getTemplate("05-test.ftl");
        //4. 获取数据模型
        Map<String, Object> data = getData();
        //5. 静态化操作
        String string = FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
        //使用到了org.apache.commons.io的工具类
        InputStream inputStream = IOUtils.toInputStream(string);
        FileOutputStream outputStream = new FileOutputStream(new File("E:/index.html"));
        IOUtils.copy(inputStream, outputStream);
    }
    private Map<String, Object> getData() {
        HashMap<String, Object> model = new HashMap<>();
        Student student = Student.builder().name("小明").age(18).build();
        //1. 纯文本形式的参数
        model.put("name", "何猛浩");
        //2. 实体类
        model.put("stu1", student);
        //2.1 小强实体类
        Student student1 = Student.builder().name("小强").age(18).money(1000.86f).birthday(new Date()).build();
        //2.1 小红实体类
        Student student2 = Student.builder().name("小红").age(18).money(1200.86f).birthday(new Date()).build();
        //将小红和小强存在list集合中
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        model.put("stuList", list);

        //创建map集合
        HashMap<String, Student> map = new HashMap<>();
        map.put("stu1", student1);
        map.put("stu2", student2);
        model.put("stuMap", map);
        return model;
    }

    /**
     * 根据字符串生成模板文件
     * @throws IOException
     * @throws TemplateException
     */
    @Test
    public void newInstance() throws IOException, TemplateException {
        //1. 获取配置文件
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        //2. 对配置类进行配置
        //2.1 获取字符串模板内容
        String template = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>Hello World!</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<#-- list 数据的展示 -->\n" +
                "<b>展示list中的stu数据:</b>\n" +
                "<br>\n" +
                "<br>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <td>序号</td>\n" +
                "        <td>姓名</td>\n" +
                "        <td>年龄</td>\n" +
                "        <td>钱包</td>\n" +
                "    </tr>\n" +
                "    <#if stuList??>\n" +
                "    <#list stuList as stu>\n" +
                "        <#if stu.name='小红'>\n" +
                "            <tr style=\"color: red\">\n" +
                "                <td>${stu_index+1}</td>\n" +
                "                <td>${stu.name}</td>\n" +
                "                <td>${stu.age}</td>\n" +
                "                <td>${stu.money}</td>\n" +
                "            </tr>\n" +
                "        </#if>\n" +
                "    </#list>\n" +
                "\n" +
                "    </#if>\n" +
                "</table>\n" +
                "<hr>\n" +
                "\n" +
                "<#-- Map 数据的展示 -->\n" +
                "<b>map数据的展示：</b>\n" +
                "<br/><br/>\n" +
                "<a href=\"###\">方式一：通过map['keyname'].property</a><br/>\n" +
                "输出stu1的学生信息：<br/>\n" +
                "姓名：${stuMap['stu1'].name}<br/>\n" +
                "年龄：${stuMap['stu1'].age}<br/>\n" +
                "<br/>\n" +
                "<a href=\"###\">方式二：通过map.keyname.property</a><br/>\n" +
                "输出stu2的学生信息：<br/>\n" +
                "姓名：${stuMap.stu2.name}<br/>\n" +
                "年龄：${stuMap.stu2.age}<br/>\n" +
                "\n" +
                "<br/>\n" +
                "<a href=\"###\">遍历map中两个学生信息：</a><br/>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <td>序号</td>\n" +
                "        <td>姓名</td>\n" +
                "        <td>年龄</td>\n" +
                "        <td>钱包</td>\n" +
                "    </tr>\n" +
                "    <#list stuMap?keys as key>\n" +
                "        <tr>\n" +
                "            <td>${key_index}</td>\n" +
                "            <td>${stuMap[key].name}</td>\n" +
                "            <td>${stuMap[key].age}</td>\n" +
                "            <td>${stuMap[key].money}</td>\n" +
                "        </tr>\n" +
                "    </#list>\n" +
                "</table>\n" +
                "<hr>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        //2.2. 创建出字符串模板加载器
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", template);
        configuration.setTemplateLoader(stringTemplateLoader);
        //3. 获取模板文件对象
        Template configurationTemplate = configuration.getTemplate("template", "utf-8");
        //4. 获取数据模型
        Map<String, Object> data = getData();
        //5. 静态话操作
        String string = FreeMarkerTemplateUtils.processTemplateIntoString(configurationTemplate, data);
        InputStream inputStream = IOUtils.toInputStream(string);
        FileOutputStream outputStream = new FileOutputStream(new File("E:/index2.html"));
        IOUtils.copy(inputStream,outputStream);
    }
}
