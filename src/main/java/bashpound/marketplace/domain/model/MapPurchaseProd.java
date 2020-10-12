package bashpound.marketplace.domain.model;


//김종찬 작성
public class MapPurchaseProd {
	private Long productId;
	private Long purchasesId;
	private Long quantity;

	@Override
	public String toString() {
		return "MapPurchaseProd [productId=" + productId + ", purchasesId=" + purchasesId + ", quantity=" + quantity
				+ "]";
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getPurchasesId() {
		return purchasesId;
	}

	public void setPurchasesId(Long purchasesId) {
		this.purchasesId = purchasesId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
