package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ThreadListProfile;

public class GetThreadList
{

  public static List<ThreadListProfile> getQueryList(){

    List<ThreadListProfile> ThredList = new ArrayList<ThreadListProfile>();

    try{
      Class.forName("oracle.jdbc.driver.OracleDriver");

      Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "cprimeuser", "cprime");
      System.out.println("GetThreadList");

      String sql = "SELECT*FROM board_thread order by th_id";
      Statement st = cn.createStatement();

      ResultSet rs = st.executeQuery(sql);

      while(rs.next()){
        ThreadListProfile cb = new ThreadListProfile();

        String id = rs.getString(1);
        String title = rs.getString(2);
        String name = rs.getString(3);
        String date = rs.getString(4);
        String category = rs.getString(5);
        String description = rs.getString(6);

        cb.setTh_id(id);
        cb.setTh_name(name);
        cb.setTh_title(title);
        cb.setTh_description(description);
        cb.setTh_date(date);
        cb.setTh_category(category);
        ThredList.add(cb);
      }

      cn.close();

      System.out.println("GetThreadList");
    }catch(ClassNotFoundException e){
      e.printStackTrace();
    }catch(SQLException e){
      e.printStackTrace();

    }catch(Exception e){
      e.printStackTrace();
    }

    return ThredList;
  }
}
