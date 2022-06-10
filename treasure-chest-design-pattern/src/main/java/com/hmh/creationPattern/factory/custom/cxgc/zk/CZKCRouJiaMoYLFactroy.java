package com.hmh.creationPattern.factory.custom.cxgc.zk;

import com.hmh.creationPattern.factory.custom.cxgc.CMeat;
import com.hmh.creationPattern.factory.custom.cxgc.CRouJiaMoYLFactroy;
import com.hmh.creationPattern.factory.custom.cxgc.CYuanLiao;

/**
 * 根据西安当地特色，提供这两种材料
 * 原料工厂
 * @author zhy
 *
 */
public class CZKCRouJiaMoYLFactroy implements CRouJiaMoYLFactroy {
 
	@Override
	public CMeat createMeat() {
		return new CZKFreshCMeat();
	}
 
	@Override
	public CYuanLiao createYuanliao() {
		return new CZKTeSeCYuanLiao();
	}
 
}