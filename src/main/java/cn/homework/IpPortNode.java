package cn.homework;
/**
 * ip跟端口
 * @author xieyiquan
 * @date 2018年7月17日
 *
 */
public class IpPortNode {
	//ip地址
	private String ip;
	//端口
	private int port;
	
	public IpPortNode(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}
	public IpPortNode() {
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return ip+"/"+port;
	}
}
