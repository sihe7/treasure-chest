package com.hmh.creationPattern.factory.custom.gcff;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: treasure-chest
 * @description:
 * @author: Mr.hemenghao
 **/
@Slf4j
public class RoujiaMo {
    protected String name;

    /**
     * 准备工作
     */
    public void prepare() {
        log.info("{}揉面-剁肉-完成准备工作",name);
    }

    /**
     * 使用你们的专用袋-包装
     */
    public void pack() {
        log.info("{}肉夹馍-专用袋-包装",name);
    }
    /**
     * 秘制设备-烘烤2分钟
     */
    public void fire() {
        log.info("{}肉夹馍-专用设备-烘烤",name);
    }
}
