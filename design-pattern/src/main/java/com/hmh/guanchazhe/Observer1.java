package com.hmh.guanchazhe;

import com.hmh.guanchazhe.server.Observer;
import com.hmh.guanchazhe.server.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Observer1 implements Observer {
	@Autowired
	private Subject subject;
 
	public Observer1(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}
 
	@Override
	public void update(String msg)
	{
		System.out.println("observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");
	}
 
}