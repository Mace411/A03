package cn.homework;
/**
 * 最后生成的zone的结构
 * @author xieyiquan
 * @date 2018年7月17日
 *
 */
public class ZoneNode {
	//zone名
	private String name;
	//server的索引
	private int serverIndex;
	//当前拥挤度
	private int capacity;
	
	public ZoneNode() {
	}
	public ZoneNode(String name, int serverIndex, int capacity) {
		super();
		this.name = name;
		this.serverIndex = serverIndex;
		this.capacity = capacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getServerIndex() {
		return serverIndex;
	}
	public void setServerIndex(int serverIndex) {
		this.serverIndex = serverIndex;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
