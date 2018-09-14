<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="json.DBCon"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="json.Person"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!class DInfo {
		private int dinum;
		private String dicode;
		private String diname;
		private String didesc;

		public DInfo() {

		}

		public int getDinum() {
			return dinum;
		}

		public void setDinum(int dinum) {
			this.dinum = dinum;
		}

		public String getDicode() {
			return dicode;
		}

		public void setDicode(String dicode) {
			this.dicode = dicode;
		}

		public String getDiname() {
			return diname;
		}

		public void setDiname(String diname) {
			this.diname = diname;
		}

		public String getDidesc() {
			return didesc;
		}

		public void setDidesc(String didesc) {
			this.didesc = didesc;
		}

		@Override
		public String toString() {
			return "DInfo [dinum=" + dinum + ", dicode=" + dicode + ", diname=" + diname + ", didesc=" + didesc + "]";
		}
	}%>
<%
	//DInfo d = gson.fromJson(request.getReader(), DInfo.class);
	//out.println(p);
	RequestDispatcher rd = request.getRequestDispatcher("/diTest/go");
	rd.forward(request, response);

	out.println(request.getAttribute("gson"));
	/* 
	Gson gson = new Gson();

	Connection con = DBCon.getCon();
	String sql = "select * from depart_info";
	List<DInfo> dList = new ArrayList<>();
	try{
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while (rs.next()) {
			DInfo d = new DInfo();
			d.setDinum(rs.getInt("dinum"));
			d.setDicode(rs.getString("diCode"));
			d.setDiname(rs.getString("diName"));
			d.setDidesc(rs.getString("diDesc"));
			dList.add(d);
		}
		out.println(gson.toJson(dList));
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		DBCon.close();
	} */
	

%>