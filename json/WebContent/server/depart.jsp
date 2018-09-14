<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="json.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@page import="json.Depart"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Gson gson = new Gson();
Depart d = gson.fromJson(request.getParameter("par"), Depart.class);
out.println(d);

Connection con = DBCon.getCon();
String sql = "select * from emp";
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

while(rs.next()){
	
}
%>