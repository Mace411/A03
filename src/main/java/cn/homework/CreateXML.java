package cn.homework;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 生成xml字符串
 * @author xieyiquan
 * @date 2018年7月17日
 *
 */
public class CreateXML extends Create{

	//域名映射的数据
	private static List<IpDomainMap> idmList = DataInit.initIpDomainMap();
	//对ip跟port处理成ip/port的字符串,并放到set集合，对重复的ip/port做了处理
	public static TreeSet<String> handleIpPort(){
		TreeSet<String> ip_port_set = new TreeSet<String>();
		for(String key : odMap.keySet()) {
			OriData od = odMap.get(key);
			ip_port_set.add(od.getIp_port().toString());
		}
		return ip_port_set;
	}
	
	//把符合条件的ip转换成域名
	public static TreeSet<String> ipToDomain(TreeSet<String> ip_port) {
		TreeSet<String> ip_port_set = new TreeSet<String>();
		for(String ip_port_str : ip_port) {
			//因为传进来的ip_port是ip/port的字符串，所以要以/分割字符串得到ip
			String ip = ip_port_str.split("/")[0];
			for(IpDomainMap idm : idmList) {
				if(ip.equals(idm.getIp()) && idm.getFlag() == 1) {
					ip_port_str = idm.getDomain();
					break;
				}
			}
			ip_port_set.add(ip_port_str);
		}
		return ip_port_set;
	}
	
	//获取server的index
	public static int getIndex(Set<String> ip_port_set,String ip_port) {
		int index = 0;
		//因为set中存储的server已经把符合要求的ip转换成了域名，但是传进来的ip是没有经过转换的，所以要先判断是否要转换
		for(IpDomainMap idm : idmList) {
			if(ip_port.split("/")[0].equals(idm.getIp()) && idm.getFlag() == 1) {
				ip_port = idm.getDomain();
				break;
			}
		}
		//遍历server的set，获得index
		for(String ip_port_str : ip_port_set) {
			if(ip_port.equals(ip_port_str)) {
				return index + 1;
			}
			index++;
		}
		return 0;
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
//	//创建xml字符串
//	public static void makeXML() {
//		cleanData();
//		TreeSet<String> ip_port_set = handleIpPort();
//		ip_port_set = ipToDomain(ip_port_set);
//		//创建xml
//		Document doc = DocumentHelper.createDocument();
//		//创建根节点
//		Element eleRoot = doc.addElement("root");
//		//创建servers子节点
//		Element eleServers = eleRoot.addElement("servers");
//		//创建server节点
//		for(String serverStr : ip_port_set) {
//			eleServers.addElement("server").setText(serverStr);
//		}
//		//创建zones节点
//		Element eleZones = eleRoot.addElement("zones");
//		for(String name : odMap.keySet()) {
//			OriData od = odMap.get(name);
//			String ip_port = od.getIp_port().toString();
//			eleZones.addElement("zone").addAttribute("name", name)
//				.addAttribute("serverIndex", String.valueOf(getIndex(ip_port_set,ip_port)))
//				.addAttribute("capacity", String.valueOf(getCapacity(od.getCurNum(), od.getMaxNum())));
//		}
//		
//		System.out.println(doc.asXML());
//	}
	@Override
	public void make() {
		cleanData();
		TreeSet<String> ip_port_set = handleIpPort();
		ip_port_set = ipToDomain(ip_port_set);
		StringBuilder sb = new StringBuilder();
		sb.append("<root><servers>");
		//添加server节点
		for(String ip_port:ip_port_set) {
			sb.append("<server>"+ip_port+"</server>");
		}
		sb.append("</servers><zones>");
		//添加zone节点
		for(String name : odMap.keySet()) {
			OriData od = odMap.get(name);
			String ip_port_str = od.getIp_port().toString();
			sb.append("<zone name=\""+od.getName()
					+"\" serverIndex=\""+String.valueOf(getIndex(ip_port_set,ip_port_str))+"\" "
					+"capacity=\""+String.valueOf(getCapacity(od.getCurNum(), od.getMaxNum()))+"\"/>");
		}
		sb.append("</zones></root>");
		System.out.println(sb);
	}
}
