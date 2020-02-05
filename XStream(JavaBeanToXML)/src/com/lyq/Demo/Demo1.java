package com.lyq.Demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

/*
 * ��ʾxstreamת��JavaBeanΪxml
 */
public class Demo1 {

	// ����JavaBean����
	public List<Province> getProvince() {
		Province province1 = new Province();
		province1.setName("����");
		province1.addCity(new City("������", "DongChengQu"));
		province1.addCity(new City("��ƽ", "ChangPing"));
		province1.addCity(new City("������", "XiChengQu"));

		Province province2 = new Province();
		province2.setName("����");
		province2.addCity(new City("����", "ShengYang"));
		province2.addCity(new City("��«��", "HuLuDao"));

		List<Province> provincesList = new ArrayList<Province>();
		provincesList.add(province1);
		provincesList.add(province2);
		return provincesList;

	}

	@Test
	public void fun1() {
		List<Province> proList = getProvince();

		/*
		 * ����xstream���� ����toxml�Ѽ���ת�����ַ���
		 */
		XStream xs = new XStream();
		String s = xs.toXML(proList);
		System.out.println(s);

	}

	/*
	 * ���� List��Ӧchina com.lyq.Demo.Province��ӦProvince com.lyq.Demo.City��ӦCity
	 */
	@Test
	public void fun2() {
		List<Province> proList = getProvince();

		/*
		 * ����xstream���� ����toxml�Ѽ���ת�����ַ���
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		
		String s = xs.toXML(proList);
		System.out.println(s);
	}
	
	/*
	 * Ĭ��JavaBean�����Զ���������Ԫ������ϣ����������
	 */
	@Test
	public void fun3() {
		List<Province> proList = getProvince();

		/*
		 * ����xstream���� ����toxml�Ѽ���ת�����ַ���
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		
		/*
		 * ��province��name��������province��Ԫ�ص�����
		 */
		xs.useAttributeFor(Province.class, "name");
		String s = xs.toXML(proList);
		System.out.println(s);
	}
	
	@Test
	public void fun4() {
		List<Province> proList = getProvince();

		/*
		 * ����xstream���� ����toxml�Ѽ���ת�����ַ���
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		
		/*
		 * ��province��name��������province��Ԫ�ص�����
		 */
		xs.useAttributeFor(Province.class, "name");
		/*
		 * ȥ��citys���������õ�����
		 * ȥ��<citys>
		 */
		xs.addImplicitCollection(Province.class, "citys");
		String s = xs.toXML(proList);
		System.out.println(s);
	}
	/*
	 * ��ĳЩJavaBean���Բ����ɶ�Ӧ��xmlԪ��
	 * ȥ��<desc>ShengYang</desc>
	 */
	@Test
	public void fun5() {
		List<Province> proList = getProvince();

		/*
		 * ����xstream���� ����toxml�Ѽ���ת�����ַ���
		 */
		XStream xs = new XStream();
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		xs.useAttributeFor(Province.class, "name");
		xs.addImplicitCollection(Province.class, "citys");
		
		//ȥ��desc
		xs.omitField(City.class, "desc");
		String s = xs.toXML(proList);
		System.out.println(s);
	}
}
