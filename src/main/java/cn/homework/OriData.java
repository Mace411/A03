package cn.homework;
/**
 * 原始的数据
 * @author xieyiquan
 * @date 2018年7月17日
 *
 */
public class OriData {
	//zone名
	private String name;
	//ip地址和端口
	private IpPortNode ip_port;
	//当前人数
	private int curNum;
	//最大人数
	private int maxNum;

	public OriData() {
	}
	
	public OriData(String name, IpPortNode ip_port, int curNum, int maxNum) {
		super();
		this.name = name;
		this.ip_port = ip_port;
		this.curNum = curNum;
		this.maxNum = maxNum;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public IpPortNode getIp_port() {
		return ip_port;
	}

	public void setIp_port(IpPortNode ip_port) {
		this.ip_port = ip_port;
	}

	public int getCurNum() {
		return curNum;
	}
	public void setCurNum(int curNum) {
		this.curNum = curNum;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
}
