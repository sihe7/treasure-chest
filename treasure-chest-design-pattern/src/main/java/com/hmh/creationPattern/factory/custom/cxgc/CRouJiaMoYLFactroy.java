package com.hmh.creationPattern.factory.custom.cxgc;
 
/**
 * 提供肉夹馍的原料
 * @author zhy
 *
 */
public interface CRouJiaMoYLFactroy {
	/**
	 * 生产肉
	 * @return
	 */
	public CMeat createMeat();
	
	/**
	 * 生产调料神马的
	 * @return
	 */
	public CYuanLiao createYuanliao();
	
}