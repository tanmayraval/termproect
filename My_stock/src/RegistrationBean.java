import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

//@ManagedBean
@ManagedBean

public class RegistrationBean {
	private String firstname;
	private String lastname;
	private String phno;
	private String emailid;
	private String username;
	private String password;
	private String usertype;
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

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

	public String registration() {
		Connection connection = null;
		//int i=0;
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

			String sql = "INSERT INTO user(firstname,lastname,emaiid,phoneno,username,password,usertype)"+" VALUES('"+firstname+"','"+lastname+"','"+emailid+"','"+phno+"','"+username+"','"+password+"','"+usertype+"')";
		    Statement s = connection.createStatement();
			s.executeUpdate(sql);
			s.close();
			connection.close();
			//return "login";
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		return "login" ;}
	private String uname = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        public String find() {
		
		ArrayList<String> rs = ManagerprofileDAO.getUser(uname);
		String array[] = new String[rs.size()];
		
		for(int j =0;j<rs.size();j++){
			  array[j] = rs.get(j);
			}
			this.setFirstname(array[0]);
			this.setLastname(array[1]);
			this.setEmailid(array[2]);
			this.setPhno(array[3]);
			this.setUsername(array[4]);
			this.setPassword(array[5]);
		
			return "managerprofile";
	}
		
	}

