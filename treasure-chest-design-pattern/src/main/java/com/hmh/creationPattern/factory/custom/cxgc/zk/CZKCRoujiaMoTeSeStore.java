package com.hmh.creationPattern.factory.custom.cxgc.zk;


import com.hmh.creationPattern.factory.custom.cxgc.CRouJiaMo;
import com.hmh.creationPattern.factory.custom.cxgc.CRoujiaMoStore;

/**
 * Created by jingbin on 2016/10/24.
 * 西安肉夹馍店   让分店自己去卖自己口味的肉夹馍
 *
 */

public class CZKCRoujiaMoTeSeStore extends CRoujiaMoStore {

    private CZKSimpleRoujiaMoFactory factory;

    public CZKCRoujiaMoTeSeStore(CZKSimpleRoujiaMoFactory factory) {
        this.factory = factory;
    }

    public CRouJiaMo sellRoujiaMo(String type) {
        CRouJiaMo roujiaMoC = factory.creatRoujiaMo(type);
        roujiaMoC.prepare(new CZKCRouJiaMoYLFactroy());
        roujiaMoC.fire();
        roujiaMoC.pack();
        return roujiaMoC;
    }
}