package service;

import java.util.List;

import dao.TicketDAO;
import vo.TicketInfo;

public class TicketService {
	private TicketDAO tdao = new TicketDAO();
	
	public List<TicketInfo> getTicketList(){
		return tdao.selectLevelInfoList();
	}
}
