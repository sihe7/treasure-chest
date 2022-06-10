package com.hmh.creationPattern.factory.custom.jdgc;

import lombok.extern.slf4j.Slf4j;

/**
 * 有各种风味的馍馍统一包装步骤
 */
@Slf4j
public abstract class RouJiaMo {
	protected String name;
 
	/**
	 * 准备工作
	 */
	public void prepare() {
		log.info("{}揉面-剁肉-完成准备工作", name);
	}
 
	/**
	 * 使用你们的专用袋-包装
	 */
	public void pack() {
		log.info("{}肉夹馍-专用袋-包装", name);
		System.out.println("");
	}
	/**
	 * 秘制设备-烘烤2分钟
	 */
	public void fire() {
		log.info("{}肉夹馍-专用设备-烘烤", name);
	}
}