package bashpound.marketplace.domain.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShippingInfomartion")
public class ShippingInfomartion extends AbstractBaseEntity {

	private static final long serialVersionUID = 7287117468157614605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "shppingNumber")
	private String shppingNumber;
	@ManyToOne
	@JoinColumn(name = "Purchase_orderNumber")
	private Purchase purchase;
	@ManyToOne
	@JoinColumn(name = "Member_username")
	private Member member;
	@Column(name = "Courier")
	private String Courier;
	@Column(name = "parcel_number")
	private Date parcel_number;
	@Column(name = "delivery_state", columnDefinition = "varchar2(255) default 'shipping'")
	private String delivery_state;

	@Override
	public String toString() {
		return "ShippingInfomartion [id=" + id + ", shppingNumber=" + shppingNumber + ", purchase=" + purchase
				+ ", member=" + member + ", Courier=" + Courier + ", parcel_number=" + parcel_number
				+ ", delivery_state=" + delivery_state + "]";
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
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
