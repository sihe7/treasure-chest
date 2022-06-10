package com.hmh.behavioralPattern.observer.custom.server.impl.fs;

import com.hmh.behavioralPattern.observer.custom.server.Observer;
import com.hmh.behavioralPattern.observer.custom.server.Subject;
import com.hmh.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 观察者1
 */
@Slf4j
@Service
public class ObserverFS1 implements Observer {
	private Subject subject;
 
	public ObserverFS1(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}
 
	@Override
	public void update(String msg) {
		//获取更新收到的时间
		String currentTime = DateUtil.getCurrent(DateUtil.SETTLE_PATTERN);
		log.info(currentTime + "黑色四叶草粉丝1 得到 电影发布消息  -->" + msg);
	}
 
}