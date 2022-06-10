package com.hmh.behavioralPattern.observer.builtIn;
 
import com.hmh.behavioralPattern.observer.builtIn.server.SubjectFor3d;
import com.hmh.behavioralPattern.observer.builtIn.server.SubjectForSSQ;

import java.util.Observable;
import java.util.Observer;

/**
 * 注册一个使用者
 */
public class Observer1 implements Observer {
 
	public void registerSubject(Observable observable) {
		//服务号内部添加观察者(粉丝)
		observable.addObserver(this);
	}
 
	@Override
	public void update(Observable o, Object arg) {
		/*
		对象运算符(instanceof)用来判断一个对象是否属于某个指定的类或其子类的实例，
		如果是，返回真(true)，否则返回假(false)。
		 */
		if (o instanceof SubjectFor3d)
		{
			SubjectFor3d subjectFor3d = (SubjectFor3d) o;
			System.out.println("subjectFor3d's msg -- >" + subjectFor3d.getMsg());
		}
 
		if (o instanceof SubjectForSSQ)
		{
			SubjectForSSQ subjectForSSQ = (SubjectForSSQ) o;
			System.out.println("subjectForSSQ's msg -- >" + subjectForSSQ.getMsg());
		}
	}
}