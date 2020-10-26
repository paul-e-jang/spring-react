package bashpound.marketplace.domain.model;

import java.util.Date;

public class Cart {

	private String username;
	private String prodName;
	private String sellerName;
	private Date prodRegdate;
	private int stock;
	private int price;
	private Date purchaseDate;
	private int quantity;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Date getProdRegdate() {
		return prodRegdate;
	}

	public void setProdRegdate(Date prodRegdate) {
		this.prodRegdate = prodRegdate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [username=" + username + ", prodName=" + prodName + ", sellerName=" + sellerName + ", prodRegdate="
				+ prodRegdate + ", stock=" + stock + ", price=" + price + ", purchaseDate=" + purchaseDate
				+ ", quantity=" + quantity + "]";
	}

}
