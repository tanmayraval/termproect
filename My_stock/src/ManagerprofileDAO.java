import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

public class ManagerprofileDAO 
{
	public static ArrayList<String> getUser(String userid){
		Connection connection = null;
        PreparedStatement ps = null;
		
		 try {
			 	connection = DataConnect.getConnection(); 
	            ps = connection.prepareStatement("SELECT firstname,lastname,emaiid,phoneno,username,password from user where username=? and usertype='manager' ");
				ps.setString(1, userid);
	                
	            java.sql.ResultSet rs = ps.executeQuery();
	            ArrayList<String> al = new ArrayList<String>();
	            boolean got=false;
	     
	            if(rs.next()) {
	            		           
	            	al.add(rs.getString("firstname"));
	            	al.add(rs.getString("lastname"));
	            	al.add(rs.getString("phono"));
	            	al.add(rs.getString("emailid"));
	            	al.add(rs.getString("username"));
	            	al.add(rs.getString("password"));
	            	//al.add(rs.getString("fees"));
	            	System.out.println(al);
	                
	            }
	            if (got) {
	            	rs.close();
		            connection.close();
	                return al;
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	            System.out.println("Error In manager retrival" + e.getMessage());
	            return null;
	        }
	      }
	public static boolean updateuser(String firstname,String lastname,String emailid,String phno,String username,String password) {
		Connection con = null;
        PreparedStatement ps = null;
        		
		 try {
			 	con = DataConnect.getConnection();
			 				 	
	            ps = con.prepareStatement("UPDATE user SET firstname=?,lastname=?, emaiid=?, phoneno=?, username=?, password=? WHERE userid=? ");
	            ps.setString(1, firstname);
	            ps.setString(2, lastname);  
	            ps.setString(3, emailid);
	            ps.setString(4, phno);
	            ps.setString(5, username);
	            ps.setString(6, password);
	       
	            
	            int rs = ps.executeUpdate();
	            
	            if(rs>0) {
	              	RegistrationBean rb = new RegistrationBean();
	            	//ls.setName(name);
	            	rb.getFirstname();
	            	rb.getLastname();
	            	rb.getEmailid();
	            	rb.getPhno();
	            	rb.getUsername();
	            	rb.getUsername();
	            	rb.getPassword();
	            	return true;
	            }
		 	}catch (Exception e) {
		 		return false;
			}
		return false;
	}
}
