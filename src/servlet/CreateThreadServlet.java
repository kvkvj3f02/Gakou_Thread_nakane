package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ThreadListProfile;
import database.CreateThread;

public class CreateThreadServlet extends HttpServlet{
  public void doGet(HttpServletRequest req,HttpServletResponse res)
  throws IOException,ServletException{
    RequestDispatcher dispatcher=
    req.getRequestDispatcher("CreateThreadServlet");
    System.out.println("CreateThreadServlet");
    dispatcher.forward(req,res);
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)
  throws IOException,ServletException{
    req.setCharacterEncoding("UTF-8");

    String th_title=req.getParameter("th_title");
    String th_name=req.getParameter("th_name");
    String th_category=req.getParameter("c1");
    String th_description=req.getParameter("th_description");

    ThreadListProfile ThreadListProfile = new ThreadListProfile();
    ThreadListProfile.setTh_title(th_title);
    ThreadListProfile.setTh_name(th_name);
    ThreadListProfile.setTh_category(th_category);
    ThreadListProfile.setTh_description(th_description);

    CreateThread.executeInsert(ThreadListProfile);

    String className = new Object(){}.getClass().getName();
		System.out.println(className);

    RequestDispatcher dispatcher=
    req.getRequestDispatcher("ThreadList");
    System.out.println("CreateThreadServlet");
    dispatcher.forward(req,res);


    }
}
