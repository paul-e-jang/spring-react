package bashpound.marketplace.domain.model;

import java.util.Objects;

//김종찬 작성
public class ProductPurchase {
	private Long id;
	private Long product_id;
	private Long purchases_id;
	private Long quantity;
	
	@Override
	public String toString() {
		return "ProdctPurchase [id=" + id + ", product_id=" + product_id + ", purchases_id=" + purchases_id
				+ ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ProductPurchase))
			return false;
		ProductPurchase o1 = (ProductPurchase) o;
		return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Long getPurchases_id() {
		return purchases_id;
	}

	public void setPurchases_id(Long purchases_id) {
		this.purchases_id = purchases_id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
