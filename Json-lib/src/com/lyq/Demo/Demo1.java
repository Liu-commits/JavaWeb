package com.lyq.Demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * json-lib小工具
 */
public class Demo1 {
	/*
	 * 当map来用
	 */
	@Test
	public void fun1(){
		JSONObject map = new JSONObject();
		map.put("name", "zhangsan");
		map.put("age", 21);
		map.put("sex", "male");
		
		String s = map.toString();
		System.out.println(s);
	}
	/*
	 * 已经有一个对象
	 */
	@Test
	public void fun2(){
		Person per= new Person("lisi",32,"male");
		//把对象转换成JSONObject对象
		JSONObject object = JSONObject.fromObject(per);
		System.out.println(object.toString());
	}
	
	/*
	 * JSONArray
	 */
	@Test
	public void fun3(){
		Person per1= new Person("zhangsan",32,"male");
		Person per2= new Person("lisi",12,"male");
		JSONArray list = new JSONArray();
		list.add(per1);
		list.add(per2);
		 
		System.out.println(list.toString());
	}
	
	@Test
	public void fun4(){
		Person per1= new Person("zhangsan",32,"male");
		Person per2= new Person("lisi",12,"male");
		List<Person> personList = new ArrayList<Person>();
		personList.add(per1);
		personList.add(per2);
		
		 
		System.out.println(JSONArray.fromObject(personList));
	}
	
}
