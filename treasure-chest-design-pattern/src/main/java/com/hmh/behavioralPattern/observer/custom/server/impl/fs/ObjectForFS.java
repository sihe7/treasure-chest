package com.hmh.behavioralPattern.observer.custom.server.impl.fs;

import com.hmh.behavioralPattern.observer.custom.server.Observer;
import com.hmh.behavioralPattern.observer.custom.server.Subject;
import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @program: treasure-chest
 * @description: 黑色四叶草电影发布服务
 * @author: Mr.hemenghao
 **/
public class ObjectForFS implements Subject {
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
