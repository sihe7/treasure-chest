package com.hmh.creationPattern.factory.custom.gcff.xa;


import com.hmh.creationPattern.factory.custom.gcff.RoujiaMo;

/**
 * Created by jingbin on 2016/10/23.
 * 西安 简单工厂模式:
 * 用来西安店生产自己店里的肉夹馍
 */

public class XianSimpleRoujiaMoFactory {

    public RoujiaMo creatRoujiaMo(String type) {
        RoujiaMo roujiaMo = null;
        //这里可以使用map存储,然后再springboot应用启动的时候加载到map集合里面当中之后获取
        switch (type) {
            case "Suan":
                roujiaMo = new XianSuanRoujiMoC();
                break;
            case "Ku":
                roujiaMo = new XianKuRoujiMo();
                break;
            case "La":
                roujiaMo = new XianlaRoujiMo();
                break;
            default:// 默认为酸肉夹馍
                roujiaMo = new XianSuanRoujiMoC();
                break;
        }
        return roujiaMo;
    }
}