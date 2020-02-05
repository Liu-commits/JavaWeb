package com.lyq.Demo;

public class City {
	private String name;//ÊĞÃû
	private String desc;//ÃèÊö
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public City(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "City [name=" + name + ", desc=" + desc + "]";
	}
	
	
}
