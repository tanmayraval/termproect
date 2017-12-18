//import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.context.FacesContext;
@ManagedBean
@SessionScoped
class Viewstockdao
{
	//private static final long serialVersionUID = 6081417964063918994L;
	public List<ViewstockBean>getStock()throws ClassNotFoundException,SQLException
	{   Connection connection=null;
	//String username;
		
		connection= DataConnect.getConnection();
		List<ViewstockBean> viewstock= new ArrayList<ViewstockBean>();
		String username= ((String) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSessionMap().get("username"));
		PreparedStatement ps=connection.prepareStatement("select stock_symbol,qty,price,amt from purchase where username=?");
		//ps.getString(1,username);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			ViewstockBean vStock=new ViewstockBean();
			vStock.setSymbol(rs.getString("stock_symbol"));
			vStock.setQty(rs.getInt("qty"));
			vStock.setPrice(rs.getDouble("price"));
			vStock.setAmt(rs.getDouble("amt"));
			vStock.setUsername(rs.getString("username"));
			System.out.println(username);
			viewstock.add(vStock);
			
		} 
		rs.close();
		ps.close();
		connection.close();
		return viewstock;
		} 
}
