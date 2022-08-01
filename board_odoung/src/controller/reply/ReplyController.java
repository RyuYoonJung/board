package controller.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Reply;
import service.ReplyService;

@WebServlet("/reply")
public class ReplyController extends HttpServlet{
	private ReplyService replyService = ReplyService.getInstance();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long rno = Long.parseLong(req.getParameter("rno"));
		System.out.println(rno);
		Reply reply = replyService.get(rno);
		System.out.println("doGet");
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(gson.toJson(reply));
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		System.out.println(reply);
		replyService.register(reply);
		System.out.println("doPost");
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter().print("두포스트");
	}
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		System.out.println(reply);
		System.out.println("doPut");
		replyService.modify(reply);
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter().print("두풋");
	}
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		System.out.println(reply);
		replyService.remove(reply.getRno());
		System.out.println("doDelete");
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter().print("두딜리트");
	}
	
}
