package com.common;
import java.sql.*;
public class SQLtest {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			 String url="jdbc:mysql;//localhost：3306/test";
			String username="root";
			 String password="root";
			 String id="123";
			 try {
				Connection con=DriverManager.getConnection(url, username, password);
				String sql="select * from student where id="+id;
				PreparedStatement SQLquery=con.prepareStatement(sql);
				ResultSet rs=SQLquery.executeQuery();
				while(rs.next())
				{
					String user=rs.getString("user");
		                 System.out.println(user);
				}
				
				if(rs!=null)
				{
					rs.close();
				}
				if(SQLquery!=null)
				{
					SQLquery.close();
				}
				 if(con!=null)
				 {
					 con.close();
				 }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			 
			
		} catch (ClassNotFoundException e) {
			System.out.println("can not find the driver");
			e.printStackTrace();
		}
        
	}

}
