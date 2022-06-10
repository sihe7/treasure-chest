package com.hmh.creationPattern.factory.custom.gcff.bj;


import com.hmh.creationPattern.factory.custom.gcff.RoujiaMo;
import com.hmh.creationPattern.factory.custom.gcff.RoujiaMoStore;

/**
 * @program: treasure-chest
 * @description: 北京分店的商铺
 * @author: Mr.hemenghao
 **/
public class BeiJingRouJiaMoStore extends RoujiaMoStore {

    private BeiJingSimpleRoujiaMoFactory factory;
    //把测试的工厂赋值与本类
    public BeiJingRouJiaMoStore(BeiJingSimpleRoujiaMoFactory factory){
        this.factory = factory;
    }

    @Override
    public RoujiaMo createRouJiaMo(String type) {
        RoujiaMo roujiaMo = factory.creatRoujiaMo(type);
        roujiaMo.fire();
        roujiaMo.pack();
        roujiaMo.prepare();
        return roujiaMo;
    }
}
