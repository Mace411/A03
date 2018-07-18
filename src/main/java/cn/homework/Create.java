package cn.homework;

import java.util.HashMap;
import java.util.List;

public abstract class Create {
	//原始数据
	public static HashMap<String,OriData> odMap = null;
	
	public abstract void make();

	//对数据进行处理，剔除zone名开头为$的数据,同时处理掉同名的zone
	public static void cleanData() {
		odMap = new HashMap<String,OriData>();
		List<OriData> odList = DataInit.initOriData();
		//把处理好的数据放到HashMap中
		for(OriData od : odList) {
			if("$".equals(String.valueOf(od.getName().charAt(0))) ) {
				continue;
			}
			odMap.put(od.getName(), od);
		}
	}
	//计算capacity
	public static int getCapacity(double curNum,double maxNum) {
		double p = curNum/maxNum;
		if(0<=p && p<0.1) {
			return 1;
		}
		if(0.1<=p && p<0.3) {
			return 2;
		}
		if(0.3<=p && p<0.4) {
			return 3;
		}
		if(0.4<=p && p<0.5) {
			return 4;
		}
		if(0.5<=p && p<0.7) {
			return 5;
		}
		if(0.7<=p && p<0.8) {
			return 6;
		}
		return 7;
	}
}
