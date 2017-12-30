package com.igate.ch4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/abc/*")
public class PathInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String path = request.getPathInfo();
		String pathTranslated = request.getPathTranslated();
		pw.println("<br/>Path>>" + path + "<BR>");
		pw.println("<br/>Path Translated>>" + pathTranslated);
		String username = request.getParameter("username");
		pw.println("<br/>Username>>" + username + "<BR>");
	}

}
