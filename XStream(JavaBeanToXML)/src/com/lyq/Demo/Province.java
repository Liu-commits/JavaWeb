package com.lyq.Demo;

import java.util.ArrayList;
import java.util.List;

public class Province {
	private String name;//Ê¡Ãû
	private List<City> citys = new ArrayList<City>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	
	public void addCity(City city){
		citys.add(city);
	}
}
