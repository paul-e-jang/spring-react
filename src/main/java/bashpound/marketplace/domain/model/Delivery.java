package bashpound.marketplace.domain.model;

import java.util.Objects;

//김종찬 작성
public class Delivery {
	private Long id;
	private String zipcode;
	private String nameOfDelivery;
	private String address1;
	private String address2;
	private boolean mainAddress;
	private Member member;

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", zipcode=" + zipcode + ", nameOfDelivery=" + nameOfDelivery + ", address1="
				+ address1 + ", address2=" + address2 + ", mainAddress=" + mainAddress + ", member=" + member + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Delivery))
			return false;
		Delivery o1 = (Delivery) o;
		return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getNameOfDelivery() {
		return nameOfDelivery;
	}

	public void setNameOfDelivery(String nameOfDelivery) {
		this.nameOfDelivery = nameOfDelivery;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public boolean isMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(boolean mainAddress) {
		this.mainAddress = mainAddress;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
