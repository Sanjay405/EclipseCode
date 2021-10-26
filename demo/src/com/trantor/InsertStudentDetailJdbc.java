package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudentDetailJdbc {

	public static void main(String[] args) {
		Connection connection = null;
		 PreparedStatement preparedStatement =null;
      try {
		 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bmst", "xyz");
		 preparedStatement = connection.prepareStatement("insert into student_tvl(sno,sname,sfee) values(?,?,?)");
         preparedStatement.setInt(1,1);
         preparedStatement.setString(2,"Sanjay");
         preparedStatement.setDouble(3,20000);
         int executeUpdate = preparedStatement.executeUpdate();
         System.out.println(executeUpdate);

     } catch (SQLException e) {
         e.printStackTrace();
         
     } finally{
         try {
             connection.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         try {
             preparedStatement.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
  }
}