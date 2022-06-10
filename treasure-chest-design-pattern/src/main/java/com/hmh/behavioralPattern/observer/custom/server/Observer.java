package com.hmh.behavioralPattern.observer.custom.server;
 
/**
 * 自定义观察者
 * 所有的观察者需要实现此接口
 */
public interface Observer {
	//观察者通知借口
	public void update(String msg);
 
}