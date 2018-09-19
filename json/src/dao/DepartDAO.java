package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;
import vo.DepartInfo;

public class DepartDAO {

	public List<DepartInfo> selectDepartInfoList(){
		Connection con = DBCon.getCon();
		List<DepartInfo> dList = new ArrayList<>();
		String sql = "select * from depart_info";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				DepartInfo d = new DepartInfo(rs.getInt("dinum"),rs.getString("dicode"),rs.getString("diname"),rs.getString("didesc"));
				dList.add(d);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCon.close();
			
		}
		
		return dList;
	}
}
