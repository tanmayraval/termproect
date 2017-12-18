import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean

public class loginBean {

	private String username;
	private String password;
	private String usertype;

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

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String login() {
		Connection connection = null;
		try {

			com.mysql.jdbc.jdbc2.optional.MysqlDataSource mds = new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
			mds.setServerName("localhost");
			mds.setPortNumber(3306);
			mds.setDatabaseName("my_stock");
			mds.setUser("root");
			mds.setPassword("Admin");
			/*
			 * mds.setServerName(System.getenv("ICSI518_SERVER"));
			 * mds.setServerName(System.getenv("ICSI518_PORT"));
			 * mds.setServerName(System.getenv("ICSI518_DB"));
			 * mds.setServerName(System.getenv("ICSI518_USER"));
			 * mds.setServerName(System.getenv("ICSI518_Password"));
			 */

			connection = mds.getConnection();

			String sql = "SELECT username,password,usertype from user where(username='" + username + "'&&password='"
					+ password + "'&&usertype='" + usertype + "')";
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
			PreparedStatement ps = connection.prepareStatement(sql);
			// ps.setString(1,username);
			// ps.setString(2,password);
			// ps.setString(3,usertype);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (usertype.equals("user")) {
					
	                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uid", rs.getString("uid"));
					return "userhome";
				}
				if (usertype.equals("manager")) {
					//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
	                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uid", rs.getString("uid"));
					return "managerhome";
				}
			}
			connection.close();
			// return "home";

		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return "login";

		// if (username.equals("admin") && password.equals("admin")){
		// return "home";}
		// else
		// return "failure";

	}
	
	
		public void logout() throws IOException {
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
	}
}
