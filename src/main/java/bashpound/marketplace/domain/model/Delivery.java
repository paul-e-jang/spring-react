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
	@Column(name = "mainAddress", unique = true)
	private String mainAddress;
	@Column(name = "subAddress", unique = true)
	private String subAddress;

	@OneToOne
	@JoinColumn(name = "Member_username", unique = true)
	private Member member;

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", mainAddress=" + mainAddress + ", subAddress=" + subAddress + ", member="
				+ member + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Complain)) return false;
	    Delivery o1 = (Delivery) o;
	    return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
