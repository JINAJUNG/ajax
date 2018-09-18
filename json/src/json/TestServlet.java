package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import common.DBCon;

@WebServlet(urlPatterns = "/diTest/*")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		Connection con = DBCon.getCon();
		
		String param = request.getParameter("param");		
		param = param.replaceAll("\"", "");
		String sql = "select * from DEPART_INFO ";
		if (!param.equals("") || param!=null) {
			sql += " where diname like '%' || ? || '%'";
		}
		List<DInfo> dList = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if (!param.equals("") || param!=null) {
				ps.setString(1, param);
			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DInfo d = new DInfo(rs.getInt("dinum"), rs.getString("dicode"), rs.getString("diname"),
						rs.getString("didesc"));
				dList.add(d);
				System.out.println(d);
			}
			pw.println(gson.toJson(dList));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		Connection con = DBCon.getCon();
		Map<String,String> pMap = gson.fromJson(request.getParameter("param"),Map.class);
		System.out.println(request.getParameter("param"));
		
		response.setContentType("text/html;charset=utf-8");
		Map<String,String> m = gson.fromJson(request.getReader(),Map.class);
		
		
		System.out.println(m);
		
		String sql = "select * from DEPART_INFO ";
		if(m!=null) {
			if (!m.get("diname").equals("") || m.get("diname")!=null) {
				sql += " where diname like '%' || ? || '%'";
			}
				
		}
		List<DInfo> dList = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if(m!=null) {
				if (!m.get("diname").equals("") || m.get("diname")!=null) {
					ps.setString(1, m.get("diname"));
				}
					
			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DInfo d = new DInfo(rs.getInt("dinum"), rs.getString("dicode"), rs.getString("diname"),
						rs.getString("didesc"));
				dList.add(d);
				System.out.println(d);
			}
			pw.println(gson.toJson(dList));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
	}

}
