package com.team12.myworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.team12.myworld.pojos.User;
import com.team12.myworld.utility.DataBaseConnection;

public class UserDAO {
	
	public boolean signUpUser(User userInfo)
	{
		boolean flag = false;
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement("insert into USER(FirstName,LastName,Email,Password,Role,Gender) values(?,?,?,?,?,?)");
			
			ps.setString(1, userInfo.getFirstName());
			ps.setString(2, userInfo.getLastName());
			ps.setString(3, userInfo.getEmailAddress());
			ps.setString(4, userInfo.getUserPassword());
			ps.setString(5, userInfo.getRole());
			ps.setString(6, userInfo.getGender());
			
			int check = ps.executeUpdate();

			if(check > 0)
			{
				flag = true;
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DataBaseConnection.closeConnection(con);
			DataBaseConnection.closeStatement(ps);
		}
		
		return flag;
}

}
