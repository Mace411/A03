package cn.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * 生成json字符串
 * @author xieyiquan
 * @date 2018年7月17日
 *
 */
public class CreateJson extends Create{
	private static List<IpPortNode> ip_port = null;
	private static List<ZoneNode> znList = null;
	//判断是否已经存在相同的ip_port
	public static boolean isExist(String ip_port_str) {
		for(IpPortNode ipn : ip_port) {
			if(ipn.toString().equals(ip_port_str)) {
				return true;
			}
		}
		return false;
	}
	//对ip跟port进行处理，去除相同的ip/port
	public static void handleServer(){
		ip_port = new ArrayList<IpPortNode>();
		for(String key : odMap.keySet()) {
			OriData od = odMap.get(key);
			//判断是否已经存在相同的
			if(isExist(od.getIp_port().toString())) {
				continue;
			}
			ip_port.add(od.getIp_port());
		}
	}
	//获得serverIndex
	public static int getIndex(String ip_port_str) {
		for(int i = 0;i<ip_port.size();i++) {
			if(ip_port_str.equals(ip_port.get(i).toString())) {
				return i+1;
			}
		}
		return 0;
	}
	//得到每一个zone节点的对象
	public static void handleZones() {
		znList = new ArrayList<ZoneNode>();
		for(String key : odMap.keySet()) {
			OriData od = odMap.get(key);
			znList.add(new ZoneNode(od.getName(),
					getIndex(od.getIp_port().toString()),
					getCapacity(od.getCurNum(), od.getMaxNum())));
		}
	}
//	public static void makeJson() {
//		cleanData();
//		handleServer();
//		handleZones();
//		JSONObject json = new JSONObject();
//		json.put("servers", ip_port);
//		json.put("zones", znList);
//		System.out.println(json);
//	}
	public void make() {
		cleanData();
		handleServer();
		handleZones();
		StringBuilder sb = new StringBuilder();
		sb.append("{\"servers\":[");
		for(IpPortNode ipn : ip_port) {
			sb.append("{\"ip\":\""+ipn.getIp()+"\",\"port\"=\""+ipn.getPort()+"\"},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("],\"zones\":[");
		for(ZoneNode zn : znList) {
			sb.append("{\"name\":\""+zn.getName()+"\",\"serverIndex\":\""
					+zn.getServerIndex()+"\",\"capacity\":\""
					+zn.getCapacity()+"\"},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]}");
		System.out.println(sb);
	}
}
