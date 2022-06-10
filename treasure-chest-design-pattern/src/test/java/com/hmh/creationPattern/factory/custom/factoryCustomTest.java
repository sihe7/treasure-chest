package com.hmh.creationPattern.factory.custom;

import com.hmh.creationPattern.factory.custom.cxgc.CRouJiaMo;
import com.hmh.creationPattern.factory.custom.cxgc.xa.CXianCRoujiaMoTeSeStore;
import com.hmh.creationPattern.factory.custom.cxgc.xa.CXianSimpleRoujiaMoFactory;
import com.hmh.creationPattern.factory.custom.cxgc.zk.CZKCRoujiaMoTeSeStore;
import com.hmh.creationPattern.factory.custom.cxgc.zk.CZKSimpleRoujiaMoFactory;
import com.hmh.creationPattern.factory.custom.gcff.RoujiaMo;
import com.hmh.creationPattern.factory.custom.gcff.bj.BeiJingRouJiaMoStore;
import com.hmh.creationPattern.factory.custom.gcff.bj.BeiJingSimpleRoujiaMoFactory;
import com.hmh.creationPattern.factory.custom.gcff.xa.XianRouJiaMoStore;
import com.hmh.creationPattern.factory.custom.gcff.xa.XianSimpleRoujiaMoFactory;
import com.hmh.creationPattern.factory.custom.jdgc.RouJiaMo;
import com.hmh.creationPattern.factory.custom.jdgc.RoujiaMoStore;
import com.hmh.creationPattern.factory.custom.jdgc.RoujiaMoStore2;
import com.hmh.creationPattern.factory.custom.jdgc.SimpleRouJiaMoFactroy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program treasure-chest
 * @description 自定义工厂模式测试类
 * @author Mr.hemenghao
 **/
@SpringBootTest
public class factoryCustomTest {
    /**
     * 简单工厂
     * 没有商店,只有工厂(用于生产对象)
     */
    @Test
    public void test01(){
        //初始化工厂对象
        RoujiaMoStore2 roujiaMoStore = new RoujiaMoStore2();
        //购买商店肉加馍
        RouJiaMo suan = roujiaMoStore.sellRouJiaMo("Suan");
        //加工馍馍
        System.out.println(suan);
    }

    /**
     * 简单工厂升级
     */
    @Test
    public void test02(){
        SimpleRouJiaMoFactroy factroy = new SimpleRouJiaMoFactroy();
        RoujiaMoStore roujiaMoStore = new RoujiaMoStore(factroy);
        RouJiaMo tian = roujiaMoStore.sellRouJiaMo("Tian");
        System.out.println(tian);
    }

    /**
     * 工厂方法模式(西安肉夹馍店)
     */
    @Test
    public void test03(){
        XianSimpleRoujiaMoFactory factory = new XianSimpleRoujiaMoFactory();
        XianRouJiaMoStore xianRouJiaMoStore = new XianRouJiaMoStore(factory);
        RoujiaMo ku = xianRouJiaMoStore.createRouJiaMo("Ku");
        System.out.println(ku);
    }
    /**
     * 工厂方法模式(北京肉夹馍店)
     */
    @Test
    public void test04(){
        BeiJingSimpleRoujiaMoFactory factory = new BeiJingSimpleRoujiaMoFactory();
        com.hmh.creationPattern.factory.custom.gcff.RoujiaMoStore moStore = new BeiJingRouJiaMoStore(factory);
        RoujiaMo ku = moStore.createRouJiaMo("Ku");
        System.out.println(ku);
    }
    /**
     * 抽象工厂模式(西安肉夹馍店)
     */
    @Test
    public void test05(){
        CXianSimpleRoujiaMoFactory factory1 = new CXianSimpleRoujiaMoFactory();
        CXianCRoujiaMoTeSeStore moTeSeStore = new CXianCRoujiaMoTeSeStore(factory1);
        CRouJiaMo ku = moTeSeStore.sellRoujiaMo("Ku");
        System.out.println(ku);
    }
    /**
     * 抽象工厂模式(周口肉夹馍店)
     */
    @Test
    public void test06(){
        CZKSimpleRoujiaMoFactory factory1 = new CZKSimpleRoujiaMoFactory();
        CZKCRoujiaMoTeSeStore moTeSeStore = new CZKCRoujiaMoTeSeStore(factory1);
        CRouJiaMo ku = moTeSeStore.sellRoujiaMo("Ku");
        System.out.println(ku);
    }
}
