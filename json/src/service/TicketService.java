package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.TicketDAO;
import vo.TicketInfo;

public class TicketService {
	private TicketDAO tdao = new TicketDAO();

	public Map<String, Object> getTicketList(TicketInfo t) {
		Map<String, Object> m = new HashMap<>();
		List<TicketInfo> tlist = tdao.selectLevelInfoList(t);
		m.put("list", tlist);
		m.put("page", 10); 
		return m;
	}

	public TicketInfo getTicket(TicketInfo t) {
		return tdao.selectTicket(t);
	}

	public int insertTicket(TicketInfo t) {
		
		return tdao.insertTicket(t);
	}

	public int updateTicket(TicketInfo t) {
		return tdao.updateTicket(t);
	}

	public int deleteTicket(TicketInfo t) {
		return tdao.deleteTicket(t);
	}
}
