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

import common.DBCon;

@WebServlet(urlPatterns = "/diTest/*")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		Connection con = DBCon.getCon();
		int dinum;
		try {
			dinum = Integer.parseInt(request.getParameter("dino"));
		} catch (NumberFormatException e) {
			dinum = 0;
		}

		String sql = "select * from DEPART_INFO ";
		if (dinum != 0) {
			sql += " where dinum=?";

		}
		List<DInfo> dList = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if (dinum != 0) {
				ps.setInt(1, dinum);
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
		doGet(request, response);
	}

}
