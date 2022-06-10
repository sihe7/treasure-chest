package com.hmh.behavioralPattern.observer.custom.server.impl.sd;

import java.util.ArrayList;
import java.util.List;

import com.hmh.behavioralPattern.observer.custom.server.Observer;
import com.hmh.behavioralPattern.observer.custom.server.Subject;
import org.springframework.stereotype.Service;

/**
 * 注册一个3D彩票服务
 */
@Service
public class ObjectFor3D implements Subject {
    //在高并发下可以采用Collections.synchronizedList(list); 保证线程是安全的
    private List<Observer> observers = new ArrayList<Observer>();
    /**
     * 3D彩票的号码
     */
    private String msg;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }

    /**
     * 主题更新消息
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }
}
