package com.lyq.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload2Servlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		
//		//获取流
//		ServletInputStream inputStream = request.getInputStream();
//		String s = IOUtils.toString(inputStream);
//		System.out.println(s);
		//得到工厂
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//得到解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			
			List<FileItem> fileItemList = upload.parseRequest(request);
			FileItem item1 = fileItemList.get(0);
			FileItem item2 = fileItemList.get(1);
			
			System.out.println("普通输出显示 ： "+"名称="+ item1.getFieldName()+"="+item1.getString("utf-8"));
			System.out.println("上传文件显示： "+"文件名称="+item2.getName()+"上传文件大小="+item2.getSize());
			
			File desFile = new File("d://"+System.currentTimeMillis()+"baibing.jpg");
			item2.write(desFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	

}
