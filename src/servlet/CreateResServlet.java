package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ResProfile;
import bean.ThreadListProfile;
import database.ResInsert;


public class CreateResServlet extends HttpServlet{
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
    req.setCharacterEncoding("UTF-8");


    // プレゼンテーション層
    String th_id=req.getParameter("id");
    String res_name=req.getParameter("res_name");
    String res_text=req.getParameter("res_text");


    ResProfile resPrifile = new ResProfile();
    resPrifile.setRes_name(res_name);
    resPrifile.setRes_text(res_text);
    resPrifile.setTh_id(th_id);
    ResInsert.executeInsert(resPrifile);
    System.out.println(th_id);

    System.out.println(th_id);
    System.out.println(res_name);
    System.out.println(res_text);

    // ビジネスロジックレイヤ
    // // 訂正前
    // List<ResProfile> ResList = ResListQuery.getQueryList(th_id);
    // req.setAttribute("ResList", ResList);

    // List<ThreadListProfile> ThreadList = listQuery.getQueryList();
    // req.setAttribute("ThreadList", ThreadList);
    // System.out.println(th_id);

    String className = new Object(){}.getClass().getName();
    System.out.println(className);

    List<ResProfile> resList=business.GetResListBusiness.insertBusinessLayer(resPrifile,th_id);
    req.setAttribute("ResList",resList);


    List<ThreadListProfile>threadList=business.GetThreadListBusiness.getAllThread();
    req.setAttribute("ThreadList",threadList);

    req.setAttribute("th_id",th_id);
    RequestDispatcher dis = req.getRequestDispatcher("iti?th_id="+th_id);
    dis.forward(req, res);
  }
}
