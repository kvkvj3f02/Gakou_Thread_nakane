package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ThreadListProfile;
import database.GetThreadList;

public class ThreadListServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doPost(req,res);
	}
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

    req.setCharacterEncoding("UTF-8");
    List<ThreadListProfile> ThreadList = GetThreadList.getQueryList();
    req.setAttribute("ThreadList", ThreadList);


    String className = new Object(){}.getClass().getName();
    System.out.println(className);

    RequestDispatcher dis = req.getRequestDispatcher("iti");

    dis.forward(req, res);
  }
}
