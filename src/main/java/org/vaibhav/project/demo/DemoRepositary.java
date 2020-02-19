package org.vaibhav.project.demo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DemoRepositary {

	
	List<Demo> demo;
	Connection con = null;
	
	public DemoRepositary()
	{
		String url="jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false";
		String user="root";//Your Username
		String pass="";//Enter your password
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public List<Demo> getDemo()
	{
		List<Demo> demo = new ArrayList<>();
		String query = "select * from trial";
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Demo a = new Demo();
				a.setID(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				demo.add(a);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return demo;
	}
	public Demo getDemo(int ID)
	{
		String query = "select * from trial where id="+ID;
		Demo a = new Demo();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				
				a.setID(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				demo.add(a);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	
	}

	public void create(Demo a)
	{
		String query = "insert into trial values(?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, a.getID());
			st.setString(2, a.getName());
			st.setInt(3, a.getPoints());
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void update(Demo a)
	{
		String query = "Update trial set name =?, points = ? where id =?;";
		try
		{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, a.getName());
			st.setInt(2, a.getPoints());
			st.setInt(3, a.getID());
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void delete(int ID)
	{
		String query = "Delete from trial where id=?";
		Demo a = new Demo();
		try
		{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1,ID);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
}
