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
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBCon.close();
	}

	public List<TicketInfo> selectLevelInfoList(TicketInfo t) {
		List<TicketInfo> tList = new ArrayList<>();
		String sql = "select * from Ticket_movie ";
		con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				t = new TicketInfo(rs.getInt("tmnum"), rs.getString("tmname"), rs.getInt("tmprice"),
						rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));
				tList.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return tList;
	}

	public TicketInfo selectTicket(TicketInfo t) {
		String sql = "select * from Ticket_movie where tmnum=?";
		con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, t.getTmnum());
			rs = ps.executeQuery();

			if (rs.next()) {
				t = new TicketInfo(rs.getInt("tmnum"), rs.getString("tmname"), rs.getInt("tmprice"),
						rs.getString("tmstartdat"), rs.getString("tmenddat"), rs.getString("tmcredat"),
						rs.getString("tmdesc"), rs.getInt("tmcnt"), rs.getString("tmimg"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return t;
	}

	public int insertTicket(TicketInfo t) {
		String sql = "insert into ticket_movie(TMNUM,TMNAME,TMPRICE,TMSTARTDAT,TMENDDAT,TMCREDAT) values (seq_tmnum.nextval,?,?,?,?,to_char(SYSDATE,'yyyymmdd'))";
		con = DBCon.getCon();
		int cnt =0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, t.getTmname());
			ps.setInt(2, t.getTmprice());
			ps.setString(3, t.getTmstartdat());
			ps.setString(4, t.getTmenddat());
			cnt= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int updateTicket(TicketInfo t) {
		String sql = "update ticket_movie set tmname=?, tmprice=?, tmstartdat=?, tmenddat=?, tmcredat=? where tmnum=?";
		con = DBCon.getCon();
		int cnt =0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, t.getTmname());
			ps.setInt(2, t.getTmprice());
			ps.setString(3, t.getTmstartdat());
			ps.setString(4, t.getTmenddat());
			ps.setString(5, t.getTmcredat());
			ps.setInt(6, t.getTmnum());
			cnt= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	public int deleteTicket(TicketInfo t) {
		String sql = "delete from ticket_movie where tmnum=?";
		con = DBCon.getCon();
		int cnt =0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, t.getTmnum());
			cnt= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}
