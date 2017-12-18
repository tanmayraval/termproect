import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class ClientBean {
	private String username;
	public ClientBean() {}
    public ClientBean(String username) 
    {
    	this.username=username;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    
}
