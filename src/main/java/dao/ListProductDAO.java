package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import context.DBContext;
import model.Product;
public class ListProductDAO {
	public List<Product> show(int i) throws Exception {
		try (Connection temp =  new DBContext().getConnection()) {
			PreparedStatement stmt = temp.prepareStatement("select * from Products  order by product_id OFFSET "+(i-1)+" ROWS\r\n"
					+ "    FETCH NEXT 5 ROWS ONLY;");

			ResultSet rs = stmt.executeQuery();
			List<Product> listProduct=new ArrayList<>();
			while(rs.next()) {
			
						Product pd=new Product(Integer.parseInt(rs.getString(1)),rs.getString(2),
								rs.getString(3),Float.parseFloat(rs.getString(4)),rs.getString(5),
								rs.getString(6),rs.getString(7),1);
						listProduct.add(pd);
				
			}
			return listProduct;
		}
	}
	public List<Product> search(String characters,int i) throws Exception {
		try (Connection temp =  new DBContext().getConnection()) {
			PreparedStatement stmt = temp.prepareStatement("select * from Products where product_name like ? order by product_id OFFSET "+(i-1)+" ROWS\r\n"
					+ "    FETCH NEXT 5 ROWS ONLY;");
			String ii="%"+characters+"%";
			stmt.setString(1,ii);
			ResultSet rs = stmt.executeQuery();
			List<Product> listProduct=new ArrayList<>();
			while(rs.next()) {
						Product pd=new Product(Integer.parseInt(rs.getString(1)),rs.getString(2),
								rs.getString(3),Float.parseFloat(rs.getString(4)),rs.getString(5),
								rs.getString(6),rs.getString(7),1);
						listProduct.add(pd);
					
			}
			return listProduct;
		}
	}
	public int total(String characters,int i) throws Exception {
		try (Connection temp =  new DBContext().getConnection()) {
			PreparedStatement stmt = temp.prepareStatement("select count(*) from Products where product_name like ?");
			String ii="%"+characters+"%";
			stmt.setString(1,ii);
			ResultSet rs = stmt.executeQuery();
			int tt=0;
			while(rs.next()) {
					tt=rs.getInt(1);
			}
			return tt;
		}
	}
	public Product getProduct(String characters) throws Exception {
	Connection temp = new DBContext().getConnection();
			PreparedStatement stmt = temp.prepareStatement("select* from Products where product_id ="+characters+";");
			ResultSet rs = stmt.executeQuery();
			Product pd=null;
			while(rs.next()) {
				
				pd =new Product(Integer.parseInt(rs.getString(1)),rs.getString(2),
					rs.getString(3),Float.parseFloat(rs.getString(4)),rs.getString(5),
					rs.getString(6),rs.getString(7),1);
			}
			return pd;
		
	}
}
/**
public Product(int id1,String name2,String description3,float price4, String src5,
	String type6,String brand7,int number8)**/