package bashpound.marketplace.domain.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

//김종찬 작성
public class Purchase {
	private Long id;
	private Member member;
	private Date purchaseDate;
	private boolean arrive;
	private Product product; 
	private List<ShippingInfomartion> shippingInformations;
	private boolean purchased;

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", member=" + member + ", purchaseDate=" + purchaseDate + ", arrive=" + arrive
				+ ", product=" + product + ", shippingInformations=" + shippingInformations + ", purchased="
				+ purchased + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Purchase))
			return false;
		Purchase o1 = (Purchase) o;
		return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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

	public Product getProducts() {
		return product;
	}

	public void setProducts(Product product) {
		this.product = product;
	}

	public List<ShippingInfomartion> getShippingInformations() {
		return shippingInformations;
	}

	public void setShippingInformations(List<ShippingInfomartion> shippingInformations) {
		this.shippingInformations = shippingInformations;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

}
