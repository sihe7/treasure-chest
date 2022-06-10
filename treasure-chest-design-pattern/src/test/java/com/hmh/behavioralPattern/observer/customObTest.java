package com.hmh.behavioralPattern.observer;


import com.hmh.behavioralPattern.observer.custom.server.impl.fs.ObjectForFS;
import com.hmh.behavioralPattern.observer.custom.server.impl.fs.ObserverFS1;
import com.hmh.behavioralPattern.observer.custom.server.impl.fs.ObserverFS2;
import com.hmh.behavioralPattern.observer.custom.server.impl.sd.ObjectFor3D;
import com.hmh.behavioralPattern.observer.custom.server.impl.sd.Observer1;
import com.hmh.behavioralPattern.observer.custom.server.impl.sd.Observer2;
import com.hmh.behavioralPattern.observer.custom.server.Observer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class customObTest {
    /**
     * 观察者模式是一对多的关系，一对一的关系可以叫回调
     * 测试3D的服务号
     */
    @Test
    public void obTest01() {
		//模拟一个3D的服务号
        ObjectFor3D subjectFor3d = new ObjectFor3D();
        //客户1
        Observer observer1 = new Observer1(subjectFor3d);
        //客户2
        Observer observer2 = new Observer2(subjectFor3d);
        //给服务号发消息，观察者来接受消息处理
        subjectFor3d.setMsg("20140420的3D号码是：127");
        subjectFor3d.setMsg("20140421的3D号码是：333");
    }
    /**
     * 观察者模式是一对多的关系，一对一的关系可以叫回调
     * 测试黑色四叶草电影发布消息推广的服务号
     */
    @Test
    public void obTest02() {
        //模拟一个3D的服务号
        ObjectForFS subjectForfs = new ObjectForFS();
        //客户1
        Observer observer1 = new ObserverFS1(subjectForfs);
        //客户2
        Observer observer2 = new ObserverFS2(subjectForfs);
        //给服务号发消息，观察者来接受消息处理
        subjectForfs.setMsg("北京地区电影院上映黑色四叶草时间为2022-06-10号上映");
        subjectForfs.setMsg("上海地区电影院上映黑色四叶草时间为2022-06-10号上映");
    }
}