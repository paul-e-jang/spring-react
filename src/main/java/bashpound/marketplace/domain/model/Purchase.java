package bashpound.marketplace.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//김종찬 작성
public class Purchase {
	private Long id;
	private String orderNumber;
	private Member member;
	private Product product;
	private Date purchaseDate;
	private boolean arrive;
	private List<MapPurchaseProd> products;
	private ShippingInfomartion shippingInformations;

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", orderNumber=" + orderNumber + ", member=" + member + ", product=" + product
				+ ", purchaseDate=" + purchaseDate + ", arrive=" + arrive + ", products=" + products
				+ ", shippingInformations=" + shippingInformations + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Purchase)) return false;
	    Purchase o1 = (Purchase) o;
	    return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public boolean isArrive() {
		return arrive;
	}

	public void setArrive(boolean arrive) {
		this.arrive = arrive;
	}

	public List<MapPurchaseProd> getProducts() {
		return products;
	}

	public void setProducts(List<MapPurchaseProd> products) {
		this.products = products;
	}

	public ShippingInfomartion getShippingInformations() {
		return shippingInformations;
	}

	public void setShippingInformations(ShippingInfomartion shippingInformations) {
		this.shippingInformations = shippingInformations;
	}
}
