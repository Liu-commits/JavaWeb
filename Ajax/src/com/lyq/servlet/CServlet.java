package com.lyq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String xml = "<students>'"+
					"<student  num='104 class'>"+
					"<name>zhangsan</name>"+
					"<age>14</age>"+
					"<sex>male</sex>"+
					"</student>"+
					"</students>";
		
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().print(xml);
		
	}

}
