package com.hmh.creationPattern.factory.custom.ybjdgc.code;

import com.hmh.creationPattern.factory.custom.ybjdgc.code.server.Shape;
import com.hmh.creationPattern.factory.custom.ybjdgc.code.server.impl.Circle;
import com.hmh.creationPattern.factory.custom.ybjdgc.code.server.impl.Rectangle;
import com.hmh.creationPattern.factory.custom.ybjdgc.code.server.impl.Square;

/**
 * @description: 创建工厂根据给定的信息生成具体类的对象
 * @author: Mr.hemenghao
 **/
public class ShapeFactory {
    //使用getShape方法获取shape类型的对象
    public Shape getShape(String shapeType){
        switch (shapeType){
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            case "SQUARE":
                return new Square();
            default:// 默认为酸肉夹馍
                return null;
        }
    }
}
