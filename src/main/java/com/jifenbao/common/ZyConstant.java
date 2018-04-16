package com.jifenbao.common;

import java.util.HashMap;
import java.util.Map;

public class ZyConstant {

	/**
	 * 影片类型
	 */
	public final static Map<String,String> SHOWTYPE = new HashMap<String,String>();
	static{
		SHOWTYPE.put("1", "2D");
		SHOWTYPE.put("2", "3D");
		SHOWTYPE.put("3", "MAX2D");
		SHOWTYPE.put("4", "MAX3D");
		SHOWTYPE.put("6", "DMAX");
	};
	
	
}
