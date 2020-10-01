package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.ResProfile;

public class QueryTest{

	public static List<ResProfile> getQueryList(String id){

		List<ResProfile> userList = new ArrayList<ResProfile>();


		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Oracleに接続を行う
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","cprimeuser","cprime");

			// スレッドIDからRESを取得する
			String sql="select res_id, res_name, res_title,res_text,res_likes from res_table WHERE res_thread_id = '"+id+"' order by res_no";

			Statement st=cn.createStatement();
			ResultSet rs=st.executeQuery(sql);

			// while ループ
			while(rs.next()){
				ResProfile prof = new ResProfile();

				String res_count = rs.getString(1);
				String res_id = rs.getString(2);
				String res_name = rs.getString(3);
				String res_text = rs.getString(4);
				String res_likes = rs.getString(5);
				prof.setRes_count(res_count);
				prof.setRes_id(res_id);
				prof.setRes_name(res_name);
				prof.setRes_text(res_text);
				prof.setRes_likes(res_likes);


				userList.add(prof);


			}

			cn.close();

		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;

	}
}
