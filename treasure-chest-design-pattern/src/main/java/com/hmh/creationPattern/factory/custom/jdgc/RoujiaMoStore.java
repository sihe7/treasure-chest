package com.hmh.creationPattern.factory.custom.jdgc;

/**
 * 一个生产肉加馍的店
 */
public class RoujiaMoStore {

//    /**
//     * 根据传入类型卖不同的肉夹馍
//     *
//     * @param type
//     * @return
//     */
//    public RouJiaMo sellRouJiaMo(String type) {
//        RouJiaMo rouJiaMo = null;
//
//        if (type.equals("Suan")) {
//            rouJiaMo = new SuanRouJiaMo();
//
//        } else if (type.equals("Tian")) {
//            rouJiaMo = new TianRouJiaMo();
//        } else if (type.equals("La")) {
//            rouJiaMo = new LaRouJiaMo();
//        }
//        rouJiaMo.prepare();
//        rouJiaMo.fire();
//        rouJiaMo.pack();
//        return rouJiaMo;
//    }
	private SimpleRouJiaMoFactroy factroy;
	public RoujiaMoStore(SimpleRouJiaMoFactroy factroy){
		this.factroy = factroy;
	}

	/**
	 * 根据传入类型卖不同的肉夹馍
	 *
	 * @param type
	 * @return
	 */
	public RouJiaMo sellRouJiaMo(String type) {
		//使用工厂创建对象
		RouJiaMo rouJiaMo = factroy.createRouJiaMo(type);
		//给对象赋予动作
		rouJiaMo.prepare();
		rouJiaMo.fire();
		rouJiaMo.pack();
		//产出产品
		return rouJiaMo;
	}
}