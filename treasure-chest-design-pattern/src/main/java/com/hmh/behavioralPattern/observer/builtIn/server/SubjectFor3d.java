package com.hmh.behavioralPattern.observer.builtIn.server;
 
import java.util.Observable;

/**
 * 3D彩票服务号主题
 */
public class SubjectFor3d extends Observable {
	private String msg ; 
	
	
	public String getMsg()
	{
		return msg;
	}
 
 
	/**
	 * 主题更新消息
	 * 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg  ;
		setChanged();
		notifyObservers();
	}
}