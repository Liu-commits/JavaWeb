package com.lyq.Demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

/*
 * 演示xstream转换JavaBean为xml
 */
public class Demo1 {

	// 返回JavaBean集合
	public List<Province> getProvince() {
		Province province1 = new Province();
		province1.setName("北京");
		province1.addCity(new City("东城区", "DongChengQu"));
		province1.addCity(new City("昌平", "ChangPing"));
		province1.addCity(new City("西城区", "XiChengQu"));

		Province province2 = new Province();
		province2.setName("辽宁");
		province2.addCity(new City("沈阳", "ShengYang"));
		province2.addCity(new City("葫芦岛", "HuLuDao"));

		List<Province> provincesList = new ArrayList<Province>();
		provincesList.add(province1);
		provincesList.add(province2);
		return provincesList;

	}

	@Test
	public void fun1() {
		List<Province> proList = getProvince();

		/*
		 * 创建xstream对象 调用toxml把集合转换成字符串
		 */
		XStream xs = new XStream();
		String s = xs.toXML(proList);
		System.out.println(s);

	}

	/*
	 * 别名 List对应china com.lyq.Demo.Province对应Province com.lyq.Demo.City对应City
	 */
	@Test
	public void fun2() {
		List<Province> proList = getProvince();

		/*
		 * 创建xstream对象 调用toxml把集合转换成字符串
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		
		String s = xs.toXML(proList);
		System.out.println(s);
	}
	
	/*
	 * 默认JavaBean的属性都会生成子元素现在希望生成属性
	 */
	@Test
	public void fun3() {
		List<Province> proList = getProvince();

		/*
		 * 创建xstream对象 调用toxml把集合转换成字符串
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		
		/*
		 * 把province的name属性生成province的元素的属性
		 */
		xs.useAttributeFor(Province.class, "name");
		String s = xs.toXML(proList);
		System.out.println(s);
	}
	
	@Test
	public void fun4() {
		List<Province> proList = getProvince();

		/*
		 * 创建xstream对象 调用toxml把集合转换成字符串
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		
		/*
		 * 把province的name属性生成province的元素的属性
		 */
		xs.useAttributeFor(Province.class, "name");
		/*
		 * 去除citys这样的无用的属性
		 * 去除<citys>
		 */
		xs.addImplicitCollection(Province.class, "citys");
		String s = xs.toXML(proList);
		System.out.println(s);
	}
	/*
	 * 让某些JavaBean属性不生成对应的xml元素
	 * 去除<desc>ShengYang</desc>
	 */
	@Test
	public void fun5() {
		List<Province> proList = getProvince();

		/*
		 * 创建xstream对象 调用toxml把集合转换成字符串
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		xs.useAttributeFor(Province.class, "name");
		xs.addImplicitCollection(Province.class, "citys");
		
		//去除desc
		xs.omitField(City.class, "desc");
		String s = xs.toXML(proList);
		System.out.println(s);
	}
}
