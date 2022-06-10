package com.hmh.creationPattern.factory.custom.gcff.xa;

import com.hmh.creationPattern.factory.custom.gcff.RoujiaMo;
import com.hmh.creationPattern.factory.custom.gcff.RoujiaMoStore;

/**
 * 西安肉夹馍店
 * 
 * @author zhy
 * 
 */
public class XianRouJiaMoStore extends RoujiaMoStore {
	private XianSimpleRoujiaMoFactory factory;

	public XianRouJiaMoStore(XianSimpleRoujiaMoFactory factory) {
		this.factory = factory;
	}

	public RoujiaMo createRouJiaMo(String type) {

		RoujiaMo roujiaMo = factory.creatRoujiaMo(type);
		roujiaMo.prepare();
		roujiaMo.fire();
		roujiaMo.pack();
		return roujiaMo;
	}
//	@Override
//	public RoujiaMo createRouJiaMo(String type) {
//		RoujiaMo roujiaMo = null;
//		switch (type) {
//			case "Suan":
//				roujiaMo = new XianSuanRoujiMo();
//				break;
//			case "Ku":
//				roujiaMo = new XianKuRoujiMo();
//				break;
//			case "La":
//				roujiaMo = new XianlaRoujiMo();
//				break;
//			default:// 默认为酸肉夹馍
//				roujiaMo = new XianSuanRoujiMo();
//				break;
//		}
//		return roujiaMo;
//
//	}
//
}