package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;


import bean.ResProfile;
import database.ResListQuery;
import bean.ThreadListProfile;
import database.GetThreadList;


public class ResList extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doPost(req,res);
	}
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

    req.setCharacterEncoding("UTF-8");
		String th_id=req.getParameter("th_id");
    List<ResProfile> ResList = ResListQuery.getQueryList(th_id);
    req.setAttribute("ResList", ResList);

		List<ThreadListProfile> ThreadList = GetThreadList.getQueryList();
    req.setAttribute("ThreadList", ThreadList);

    System.out.println(th_id);

    System.out.println("ResList 25");
    RequestDispatcher dis = req.getRequestDispatcher("iti");

    dis.forward(req, res);
  }
}
