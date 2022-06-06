package com.hmh.guanchazhe;


import com.hmh.guanchazhe.server.Observer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class obTest {
    /**
     * 观察者模式是一对多的关系，一对一的关系可以叫回调
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

}