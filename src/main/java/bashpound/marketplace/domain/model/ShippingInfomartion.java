package bashpound.marketplace.domain.model;

import java.util.Date;
import java.util.Objects;

//김종찬 작성
public class ShippingInfomartion extends AbstractBaseEntity {
	private Long id;
	private String shppingNumber;
	private Purchase purchase;
	private String Courier;
	private Date parcel_number;
	private String delivery_state;
	
	@Override
	public String toString() {
		return "ShippingInfomartion [id=" + id + ", shppingNumber=" + shppingNumber + ", purchase=" + purchase
				+ ", Courier=" + Courier + ", parcel_number=" + parcel_number + ", delivery_state=" + delivery_state
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ShippingInfomartion))
			return false;
		ShippingInfomartion o1 = (ShippingInfomartion) o;
		return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShppingNumber() {
		return shppingNumber;
	}

	public void setShppingNumber(String shppingNumber) {
		this.shppingNumber = shppingNumber;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public String getCourier() {
		return Courier;
	}

	public void setCourier(String courier) {
		Courier = courier;
	}

	public Date getParcel_number() {
		return parcel_number;
	}

	public void setParcel_number(Date parcel_number) {
		this.parcel_number = parcel_number;
	}

	public String getDelivery_state() {
		return delivery_state;
	}

	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}
}
