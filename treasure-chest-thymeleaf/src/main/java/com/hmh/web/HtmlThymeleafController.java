package com.hmh.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
* @description: TODO
* @author 杨镇宇
* @date 2022/4/7 23:30
* @version 1.0
*/
@Controller
public class HtmlThymeleafController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","age");
        return "main";
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Map map){
        map.put("info", "这是从controller转到前端界面的数据");
        return "index2";
    }
    @RequestMapping("hello2")
    public String sayHello(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五","赵柳"));
        return "success";
    }

}
