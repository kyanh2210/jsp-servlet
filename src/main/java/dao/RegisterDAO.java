package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Account;
import context.DBContext;
import model.Product;
import model.historycart;

public class RegisterDAO {
	public void InsertUser(Account acc) throws Exception {
		Connection conn=new DBContext().getConnection();
		String setacc="insert into [dbo].[Account] values('"+acc.getUsr()+"','"+acc.getPwd()+"','"+acc.getRole()+"','"+acc.getName()+"','"+acc.getAddress()+"','"+acc.getPhone()+"');";
		PreparedStatement stmt = conn.prepareStatement(setacc);
		stmt.executeUpdate();
	}
	public List<historycart> searchUser(String a) throws Exception {
		Connection conn=new DBContext().getConnection();
		String setacc="Select[dbo].[Orders_detail].order_id, [dbo].[Orders_detail].amount_product,[product_name] , [dbo].[Orders].[order_date]from Account join [dbo].[Orders] on Account.user_mail=Orders.user_mail join [dbo].[Orders_detail] on \r\n"
				+ "[dbo].[Orders].[order_id]=[dbo].[Orders_detail].order_id  join [dbo].[Products] on [dbo].[Products].product_id=Orders_detail.order_id where [dbo].[Account].[user_mail]='"+a+"'";
		PreparedStatement stmt = conn.prepareStatement(setacc);
		ResultSet x = stmt.executeQuery();
		List<historycart> list=new ArrayList<>();
		while(x.next()) {
			historycart ct=new historycart(x.getInt(1),x.getInt(2),x.getString(3),x.getDate(4));
			list.add(ct);
		}
		
		return list;
		
	}
}
