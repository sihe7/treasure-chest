package com.hmh.creationPattern.factory.custom.cxgc;

import com.hmh.creationPattern.factory.custom.cxgc.xa.CXianFreshCMeat;

public abstract class CRouJiaMo {
    protected String name;

    /**
     * 准备工作
     */
    public final void prepare(CRouJiaMoYLFactroy ylFactroy) {
        CMeat cMeat = ylFactroy.createMeat();
		CYuanLiao yuanliao = ylFactroy.createYuanliao();
        System.out.println(name + "使用官方的原料" + cMeat + " , " + yuanliao + "作为原材料制作肉夹馍 ");
    }

    /**
     * 使用你们的专用袋-包装
     */
    public final void pack() {
        System.out.println(name + "肉夹馍-专用袋-包装");
    }

    /**
     * 秘制设备-烘烤2分钟
     */
    public final void fire() {
        System.out.println(name + "肉夹馍-专用设备-烘烤");
    }
}