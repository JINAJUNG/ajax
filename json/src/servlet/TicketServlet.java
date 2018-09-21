package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.TicketService;
import vo.DepartInfo;
import vo.PageInfo;
import vo.TicketInfo;

@WebServlet("/api/ticket/*")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();
	private TicketService ts = new TicketService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("param");
		TicketInfo t = new TicketInfo();
		if (t != null  && !t.equals("") && param!=null) {
			t = gson.fromJson(param, TicketInfo.class);
		}
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);

		if (cmd.equals("list")) {
			Map<String, Object> m = new HashMap<>();
			doWrite(response, ts.getTicketList(t));
		} else if (cmd.equals("view")) {
			doWrite(response, ts.getTicket(t));
		} else {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketInfo t = gson.fromJson(request.getReader(), TicketInfo.class);
		
		int cnt = ts.insertTicket(t);
		Map<String, Integer> m = new HashMap<>();
		m.put("cnt", cnt);
		doWrite(response, m);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketInfo t = gson.fromJson(request.getReader(), TicketInfo.class);
		int cnt = ts.updateTicket(t);
		Map<String, Integer> m = new HashMap<>();
		m.put("cnt", cnt);
		doWrite(response, m);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TicketInfo t = gson.fromJson(request.getReader(), TicketInfo.class);
		int cnt = ts.deleteTicket(t);
		Map<String, Integer> m = new HashMap<>();
		m.put("cnt", cnt);
		doWrite(response, m);

	}

	private void doWrite(HttpServletResponse response, Object obj) throws IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(gson.toJson(obj));
		pw.flush();
	}
}
