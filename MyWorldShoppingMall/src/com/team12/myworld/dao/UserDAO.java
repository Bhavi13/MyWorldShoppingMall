package com.team12.myworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public User login(String userId, String passWord)
	{
		boolean flag = false;
		Connection con=null;
		PreparedStatement prpstmnt = null;
		PreparedStatement ps = null;
		User userObj = new User();

		con = DataBaseConnection.getDataBaseConnection();
		try 
		{
			prpstmnt = con.prepareStatement("Select count(*) from USER where Email = ? && Password = ?");
			prpstmnt.setString(1, userId);
			prpstmnt.setString(2, passWord);

			ResultSet result = prpstmnt.executeQuery();

			if(result.next())
				if(result.getInt(1)>0)
					flag = true;
			
			
			if(flag == true)
			{
				ps=con.prepareStatement("select * from USER where Email = ? && Password = ?");
				ps.setString(1, userId);
				ps.setString(2, passWord);

				ResultSet set = ps.executeQuery();
				while(set.next())
				{
					userObj.setFirstName(set.getString("FirstName"));
					userObj.setEmailAddress(set.getString("Email"));
					userObj.setGender(set.getString("Gender"));
					userObj.setLastName(set.getString("LastName"));
					userObj.setRole(set.getString("Role"));
				}
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
			DataBaseConnection.closeStatement(prpstmnt);
			DataBaseConnection.closeStatement(ps);
		}
		return userObj;
	}
}
