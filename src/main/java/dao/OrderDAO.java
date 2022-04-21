package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrderDAO {
	public void insertOrder(Orders o,Cart c) throws Exception {
		Connection conn= new DBContext().getConnection();
		String username= o.getUserMail();
		String discount=o.getDiscount();
		String address=o.getAddress();
		Date date=new Date();
		java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
		int status=o.getStatus();
		String getMaxId="select TOP 1 order_id from Orders order by order_id desc";
		PreparedStatement stmt = conn.prepareStatement(getMaxId);
		ResultSet rs = stmt.executeQuery();
		int tt=0;
		while(rs.next()) {
				tt=rs.getInt(1);
		}
		tt++;
		String insert="";
		for(Product p:c.getItems()) {
			insert+="insert into[dbo].[Orders_detail] values("+tt+","+p.getId()+","+p.getNumber()+","+p.getPrice()+");\r\n";
		}
		String queryEx="set IDENTITY_INSERT [dbo].[Orders] on;\r\n"
				+ "insert into [dbo].[Orders]([user_mail],[order_id],[order_status],[order_date],[order_discount_code],[order_address])\r\n"
				+" values('"+username+"',"+tt+","+status+",'"+sqlDate+"','"+discount+"','"+address+"');\r\n"
				+ "set IDENTITY_INSERT [dbo].[Orders] off;\r\n";

		PreparedStatement excu2=conn.prepareStatement(insert);
		PreparedStatement excu = conn.prepareStatement(queryEx);
		excu.executeUpdate();
		excu2.executeUpdate();
	}
}
