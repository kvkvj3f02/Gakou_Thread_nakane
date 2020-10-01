package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ResProfile;

public class ResListQuery{

    public static List<ResProfile> getQueryList(String th_id){


      List<ResProfile> ResList = new ArrayList<ResProfile>();

      try{
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "cprimeuser", "cprime");
        System.out.println("ResListQuery");

        String sql = "SELECT*FROM board_res WHERE th_id="+th_id;
        Statement st = cn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
          ResProfile cb = new ResProfile();


          String res_name = rs.getString(3);
          String res_text = rs.getString(5);
          String res_date = rs.getString(4);

          cb.setRes_name(res_name);
          cb.setRes_text(res_text);
          cb.setRes_date(res_date);
          ResList.add(cb);
        }

        cn.close();

      }catch(ClassNotFoundException e){
        e.printStackTrace();
      }catch(SQLException e){
        e.printStackTrace();
      }catch(Exception e){
        e.printStackTrace();
      }

      return ResList;
    }
}
