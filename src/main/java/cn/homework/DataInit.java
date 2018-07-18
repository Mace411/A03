package cn.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟文本文件的读取，实际数据是一开始已经利用存在内存中
 * @author xieyiquan
 * @date 2018年7月17日
 *
 */
public class DataInit {

	public static List<OriData> initOriData() {
		List<OriData> odList = new ArrayList<OriData>();
		odList.add(new OriData("阿尔岛",new IpPortNode("192.168.1.5",8000),20,300));
		odList.add(new OriData("可可岛",new IpPortNode("192.168.1.5",8000),60,400));
		odList.add(new OriData("奥比岛",new IpPortNode("192.168.1.5",8000),90,300));
		odList.add(new OriData("波比岛",new IpPortNode("192.168.1.6",8000),60,300));
		odList.add(new OriData("奥拉岛",new IpPortNode("192.168.1.6",8000),70,300));
		odList.add(new OriData("奥奇岛",new IpPortNode("95.63.1.100",8003),50,300));
		odList.add(new OriData("奥雅岛",new IpPortNode("95.68.31.115",8001),180,300));
		odList.add(new OriData("$test",new IpPortNode("95.68.31.115",8003),1,300));
		return odList;
	}
	public static List<IpDomainMap> initIpDomainMap(){
		List<IpDomainMap> idmList = new ArrayList<IpDomainMap>();
		idmList.add(new IpDomainMap("192.168.1.5", "socket1.bt.com", 1));
		idmList.add(new IpDomainMap("192.168.1.6", "socket2.bt.com", 0));
		return idmList;
	}
}
