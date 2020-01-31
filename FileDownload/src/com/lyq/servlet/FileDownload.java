package com.lyq.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class FileDownload extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 两个头一个流
		 * content type
		 * contentDisposition
		 */
		String fileName = "D:/KwDownload/song/xs.mp3";
		//获取文件的mime type类型
		String contentType = this.getServletContext().getMimeType(fileName);
		String contentDisposition = "attachment;filename=a.mp3";
		FileInputStream fis = new FileInputStream(fileName);
		//设置响应头
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		
		//获取了相应端的流
		ServletOutputStream sos = response.getOutputStream();
		
		//把输入流中的数据写入到输出流中
		IOUtils.copy(fis, sos);
		
		fis.close();

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
