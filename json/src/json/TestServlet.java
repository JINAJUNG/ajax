package json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns = "/diTest/*")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		Connection con = DBCon.getCon();
		int dino;
		try {
			dino = Integer.parseInt(request.getParameter("dino"));	
		}catch(NumberFormatException e) {
			dino = 0;
		}
		
		String sql = "select * from DIPART_INFO";
		if(dino!=0) {
			sql +=" where dino=?";
		}
		
		
		List<DInfo> dList = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if(dino!=0) {
			ps.setInt(1, dino);
			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DInfo d = new DInfo(rs.getInt("dino"),rs.getString("diname"),rs.getString("didesc"),rs.getInt("dicnt"));
				dList.add(d);
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
		doGet(request, response);
	}

}
