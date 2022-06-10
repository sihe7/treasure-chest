package com.hmh.creationPattern.factory.custom.cxgc.xa;


import com.hmh.creationPattern.factory.custom.cxgc.CRoujiaMoStore;
import com.hmh.creationPattern.factory.custom.cxgc.CRouJiaMo;

/**
 * Created by jingbin on 2016/10/24.
 * 西安肉夹馍店   让分店自己去卖自己口味的肉夹馍
 *
 */

public class CXianCRoujiaMoTeSeStore extends CRoujiaMoStore {

    private CXianSimpleRoujiaMoFactory factory;

    public CXianCRoujiaMoTeSeStore(CXianSimpleRoujiaMoFactory factory) {
        this.factory = factory;
    }

    public CRouJiaMo sellRoujiaMo(String type) {
        CRouJiaMo roujiaMoC = factory.creatRoujiaMo(type);
        roujiaMoC.prepare(new CXianCRouJiaMoYLFactroy());
        roujiaMoC.fire();
        roujiaMoC.pack();
        return roujiaMoC;
    }
}