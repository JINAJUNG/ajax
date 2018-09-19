package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.LevelInfo;
import vo.TicketInfo;

public class TicketDAO {
	public List<TicketInfo> selectLevelInfoList() {
		Connection con = DBCon.getCon();
		List<TicketInfo> tList = new ArrayList<>();
		String sql = "select * from Ticket_movie";

		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				TicketInfo ti = new TicketInfo(rs.getInt("tmnum"), rs.getString("tmname"), rs.getInt("tmprice"),
						rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));
				tList.add(ti);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return tList;
	}
}
