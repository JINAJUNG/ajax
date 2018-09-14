<%@page import="json.EmpInfo"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String req = request.getParameter("param");
Gson gson = new Gson();
EmpInfo ei = gson.fromJson(req, EmpInfo.class);
out.println(ei);
%>