package com.hmh.behavioralPattern.observer.custom.server.impl.sd;

import com.hmh.behavioralPattern.observer.custom.server.Observer;
import com.hmh.behavioralPattern.observer.custom.server.Subject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 观察者2
 */
@Slf4j
@Service
public class Observer2 implements Observer {
	private Subject subject ;
	
	public Observer2(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}
	
	@Override
	public void update(String msg) {
		log.info("观察者2 得到 3D 号码  --> {}  , 我要记下来告诉舍友。", msg);
	}
}