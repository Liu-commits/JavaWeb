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
		 * ����ͷһ����
		 * content type
		 * contentDisposition
		 */
		String fileName = "D:/KwDownload/song/xs.mp3";
		//��ȡ�ļ���mime type����
		String contentType = this.getServletContext().getMimeType(fileName);
		String contentDisposition = "attachment;filename=a.mp3";
		FileInputStream fis = new FileInputStream(fileName);
		//������Ӧͷ
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		
		//��ȡ����Ӧ�˵���
		ServletOutputStream sos = response.getOutputStream();
		
		//���������е�����д�뵽�������
		IOUtils.copy(fis, sos);
		
		fis.close();

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}
