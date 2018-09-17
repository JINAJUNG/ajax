<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String tmpPath = System.getProperty("java.io.tmpdir");
	out.println(tmpPath);	
	File tmpdir = new File(tmpPath);
	if(!tmpdir.isDirectory()){
		return; //tmpPath가 폴더가 아닐경우 리턴
	}
	DiskFileItemFactory dfactory = new DiskFileItemFactory();
	dfactory.setRepository(tmpdir);
	ServletFileUpload sfu =new ServletFileUpload(dfactory);
	sfu.setFileSizeMax(1024*1024*100);
	sfu.setSizeMax(1024*1024*200);
	String savePath = "C:/jsp_study/workspace/git/ajax/json/WebContent/files";
	
	List<FileItem> fList = sfu.parseRequest(request);
	for(int i=0;i<fList.size();i++){
		FileItem fi = fList.get(i);
		if(fi.isFormField()){
			out.println(fi.getFieldName()+" : "+fi.getString("utf-8")); //file이 아닐땐 getString으로 value가져옴
		}else{
			if(fi.getName().equals("")) continue;
			out.println("<br>"+fi.getFieldName()+" : "+fi.getName()); //file일 때 getName로 파일 명 가져옴
			savePath = savePath+File.separator+fi.getName();
			out.println(savePath);
			File saveDir = new File(savePath);
			fi.write(saveDir);
		}
	}
%>