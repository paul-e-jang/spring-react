package bashpound.marketplace.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Delivery")
public class Delivery extends AbstractBaseEntity {

	private static final long serialVersionUID = -1606406039125005563L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "zipcode")
	private String zipcode;
	@Column(name = "name_of_delivery")
	private String name_of_delivery;
	@Column(name = "address1", unique = true)
	private String address1;
	@Column(name = "address2", unique = true)
	private String address2;
	@Column(name = "is_main_address", columnDefinition = "number(1) default 1")
	private boolean is_main_address;
	@OneToOne
	@JoinColumn(name = "Member_username", unique = true)
	private Member member;

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", zipcode=" + zipcode + ", name_of_delivery=" + name_of_delivery + ", address1="
				+ address1 + ", address2=" + address2 + ", is_main_address=" + is_main_address + ", member=" + member
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
		if (!(o instanceof Complain))
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

	public String getName_of_delivery() {
		return name_of_delivery;
	}

	public void setName_of_delivery(String name_of_delivery) {
		this.name_of_delivery = name_of_delivery;
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

	public boolean isIs_main_address() {
		return is_main_address;
	}

	public void setIs_main_address(boolean is_main_address) {
		this.is_main_address = is_main_address;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
