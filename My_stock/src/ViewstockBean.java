public class ViewstockBean 
{
	private String symbol;
	private int qty;
	private double price;
	private double amt;
	private String username;
	
	public void stock(String symbol,int qty,double price, double amt)
	{
		this.symbol=symbol;
		this.qty=qty;
		this.price=price;
		this.amt=amt;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
