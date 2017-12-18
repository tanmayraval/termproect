import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ManagerProfile {
	private String firstname;
	private String lastname;
	private String phno;
	private String emailid;
	private String username;
	private String password;
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
	
public String edit() {
		
		ArrayList<String> rs = ManagerprofileDAO.getUser(uname);
			return "editmanager";
		
	}
	
public String update() {
			
		boolean rs = ManagerprofileDAO.updateuser(firstname,lastname,emailid,phno,username,password);
		
		if(rs) {
			return "managerprofile";
		}else {
			return "editmanager";
		}
		
		
    }


	public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }

	

}
