package com.hmh.creationPattern.factory.custom.cxgc.zk;


import com.hmh.creationPattern.factory.custom.cxgc.CRouJiaMo;
import com.hmh.creationPattern.factory.custom.cxgc.xa.mo.CXianKuRoujiMoC;
import com.hmh.creationPattern.factory.custom.cxgc.xa.mo.CXianLaRoujiMoC;
import com.hmh.creationPattern.factory.custom.cxgc.xa.mo.CXianSuanRoujiMoC;
import com.hmh.creationPattern.factory.custom.cxgc.zk.mo.CZKKuRoujiMoC;
import com.hmh.creationPattern.factory.custom.cxgc.zk.mo.CZKLaRoujiMoC;
import com.hmh.creationPattern.factory.custom.cxgc.zk.mo.CZKSuanRoujiMoC;

/**
 * Created by jingbin on 2016/10/23.
 * 西安 简单工厂模式:
 * 用来西安店生产自己店里的肉夹馍
 * 产品工厂
 */

public class CZKSimpleRoujiaMoFactory {

    public CRouJiaMo creatRoujiaMo(String type) {
        CRouJiaMo roujiaMoC = null;
        //这里可以使用map存储,然后再springboot应用启动的时候加载到map集合里面当中之后获取
        switch (type) {
            case "Suan":
                roujiaMoC = new CZKSuanRoujiMoC();
                break;
            case "Ku":
                roujiaMoC = new CZKKuRoujiMoC();
                break;
            case "La":
                roujiaMoC = new CZKLaRoujiMoC();
                break;
            default:// 默认为酸肉夹馍
                roujiaMoC = new CZKSuanRoujiMoC();
                break;
        }
        return roujiaMoC;
    }
}