package com.hmh.creationPattern.factory.custom.gcff.bj;


import com.hmh.creationPattern.factory.custom.gcff.RoujiaMo;

/**
 * 北京 简单工厂模式:
 * 用来北京店生产自己店里的肉夹馍
 */

public class BeiJingSimpleRoujiaMoFactory {

    public RoujiaMo creatRoujiaMo(String type) {
        RoujiaMo roujiaMo = null;
        //这里可以使用map存储,然后再springboot应用启动的时候加载到map集合里面当中之后获取
        switch (type) {
            case "Suan":
                roujiaMo = new BeiJingSuanRoujiMo();
                break;
            case "Ku":
                roujiaMo = new BeiJingKuRoujiMo();
                break;
            case "La":
                roujiaMo = new BeiJinglaRoujiMo();
                break;
            default:// 默认为酸肉夹馍
                roujiaMo = new BeiJingSuanRoujiMo();
                break;
        }
        return roujiaMo;
    }
}