package cn.homework;

/**
 * ip跟域名的映射关系
 * @author xieyiquan
 * @date 2018年7月17日
 *	
 */
public class IpDomainMap {
	//ip地址
	private String ip;
	//域名
	private String domain;
	//标识，是否需要替换ip地址
	private int flag;
	
	public IpDomainMap() {
	}
	public IpDomainMap(String ip, String domain, int flag) {
		super();
		this.ip = ip;
		this.domain = domain;
		this.flag = flag;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
