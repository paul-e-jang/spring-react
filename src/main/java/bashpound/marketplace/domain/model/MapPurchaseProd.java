package bashpound.marketplace.domain.model;

import java.util.Objects;

//김종찬 작성
public class MapPurchaseProd {
	private Long product_id;
	private Long purchases_id;
	private Long quantity;

	@Override
	public String toString() {
		return "MapPurchaseProd [product_id=" + product_id + ", purchases_id=" + purchases_id + ", quantity=" + quantity
				+ "]";
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
