package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.DepartService;
import service.TicketService;
import vo.TicketInfo;

@WebServlet("/api/json/*")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private DepartService ds = new DepartService();
	private TicketService ts = new TicketService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if (cmd.equals("DiList")) {
			String param = request.getParameter("param");
			param = param.replace("\"", "");
			System.out.println(param); 
			String json = gson.toJson(ds.getDepartInfoList());
			pw.print(json);
		} else if (cmd.equals("TiList")) {
			String json = gson.toJson(ts.getTicketList(new TicketInfo()));
			pw.println(json);
		} else {
			response.setStatus(404);
			pw.println("주소아니자나");
			pw.flush();
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
