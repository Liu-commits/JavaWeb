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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;

public class Upload3Servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//得到工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//得到解析器
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		//解析数据
		try {
			List<FileItem> item = fileUpload.parseRequest(request);
			//得到文件表单项
			FileItem fi = item.get(1);
			//得到根路径
			String root = this.getServletContext().getRealPath("WEB-INF/files/");
			//处理文件名称的绝对路径问题
			String filename = fi.getName();
			int indexOf = filename.lastIndexOf("//");
			if (indexOf != -1) {
				filename = filename.substring(indexOf+1);
				
			}
			//处理文件重名问题
			String savename = CommonUtils.uuid()+"_"+filename;
			//得到hashcode
			int hcode = filename.hashCode();
			//转换16进制
			String hexString = Integer.toHexString(hcode);
			//获取hex的前两个字母与root构成文件路径
			File dirFile = new File(root+"/"+hexString.charAt(0)+"/"+hexString.charAt(1));
			//创建目录链接，如果都存在，不创建，少一个就创建一个
			dirFile.mkdirs();
			//创建目标目录文件
			File destFile = new File(dirFile,savename);
			//保存文件
			fi.write(destFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
