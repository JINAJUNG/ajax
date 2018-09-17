<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Gson gson = new Gson();
	String tmpPath = System.getProperty("java.io.tmpdir");
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
	Map<String, String> m = new HashMap<String,String>();
	for(int i=0;i<fList.size();i++){
		FileItem fi = fList.get(i);
		if(fi.isFormField()){
			m.put(fi.getFieldName(),fi.getString("utf-8")); //file이 아닐땐 getString으로 value가져옴
		}else{
			if(fi.getName().equals("")) continue;
			//out.println("<br>"+fi.getFieldName()+" : "+fi.getName()); //file일 때 getName로 파일 명 가져옴
			if(fi.getName().lastIndexOf(".png")==-1 || fi.getName().lastIndexOf(".PNG")==-1){
				m.put("com","-1");
				m.put("msg","사진형식이 올바르지 않아요");
				out.println(gson.toJson(m));
				//out.println("사진형식이 올바르지 않아요");
				return;
			}
			savePath = savePath+File.separator+fi.getName();
			out.println(savePath);
			File saveDir = new File(savePath);
			fi.write(saveDir);
		}
	}
%>