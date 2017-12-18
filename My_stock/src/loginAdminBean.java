import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
@ManagedBean

public class loginAdminBean {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String login()
	{
		Connection connection = null;
		try {
			
			com.mysql.jdbc.jdbc2.optional.MysqlDataSource mds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
			mds.setServerName("localhost");
			mds.setPortNumber(3306);
			mds.setDatabaseName("my_stock");
			mds.setUser("root");
			mds.setPassword("Admin");
			/*mds.setServerName(System.getenv("ICSI518_SERVER"));
			mds.setServerName(System.getenv("ICSI518_PORT"));
			mds.setServerName(System.getenv("ICSI518_DB"));
			mds.setServerName(System.getenv("ICSI518_USER"));
			mds.setServerName(System.getenv("ICSI518_Password"));*/

	
			connection = mds.getConnection();

			String sql = "SELECT username,password from admin where username=? and password=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				return "adminDashboard";
			}
			connection.close();
					
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		} 
		return "loginadmin";
			
	}
	public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("loginadmin.xhtml");
}
}




