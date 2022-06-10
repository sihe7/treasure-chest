package com.hmh.creationPattern.factory.custom.jdgc;

public class SimpleRouJiaMoFactroy {
    public RouJiaMo createRouJiaMo(String type) {
        RouJiaMo rouJiaMo = null;
        switch (type){
            case "Suan":
                rouJiaMo = new SuanRouJiaMo();
                break;
            case "Tian":
                rouJiaMo = new TianRouJiaMo();
                break;
            case "La":
                rouJiaMo = new LaRouJiaMo();
                break;
            default:// 默认为酸肉夹馍
                rouJiaMo = new SuanRouJiaMo();
                break;
        }
        return rouJiaMo;
    }
}