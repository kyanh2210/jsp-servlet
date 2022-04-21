package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Account;
import bean.adminpassword;
import context.DBContext;

public class adminpass {
	public List<Account> listad() throws Exception{
		Connection conn= new DBContext().getConnection();
		  PreparedStatement stmt = conn.prepareStatement("select * from Account");
		  ResultSet rs = stmt.executeQuery();
		  List<Account> x = new ArrayList<>();
		while(rs.next()) {
			Account a= new Account(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),1);
			x.add(a);
		}
		return x;
		
	}
}
