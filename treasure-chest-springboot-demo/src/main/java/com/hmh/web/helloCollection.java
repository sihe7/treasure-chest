package com.hmh.web;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: springboot测试类
 * @author: Mr.hemenghao
 **/
@RestController
public class helloCollection {
    /**
     * @GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
     */
    /**
     * Hello，World
     *
     * @param who 参数，非必须
     * @return Hello, ${who}
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if (StrUtil.isBlank(who)) {
            who = "World";
        }
        return StrUtil.format("Hello, {}!", who);
    }
    @GetMapping("/hello/{username}")
    public String bindAccountRole(@PathVariable String username, @RequestParam(required = false, name = "roleCodes") String [] roleCodes) {
        return StrUtil.format("Hello, {}!", username);
    }
}
