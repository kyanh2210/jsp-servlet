package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	private final String serverName="localhost";
	private final String dbName="ShoppingDB";
	private final String portNumber="1433";
	private final String instance="";
	private final String userID= "some";
	private final String password="1";
	public Connection getConnection() throws Exception {
		String url="jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName="+dbName+";trustServerCertificate=true;Encrypt=True";
		if(instance=="") {
			url="jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName+";trustServerCertificate=true;Encrypt=True";
		}
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		return DriverManager.getConnection(url, userID, password);
		
	}
}
