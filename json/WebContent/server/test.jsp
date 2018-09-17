<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.DBCon"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="json.Person"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	RequestDispatcher rd = request.getRequestDispatcher("/diTest/go");
	rd.forward(request, response);

	out.println(request.getAttribute("gson"));
%>