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
	@Column(name = "method")
	private String method;
	@Column(name = "duration")
	private Date duration;
	@Column(name = "complete")
	private boolean complete;

	@Override
	public String toString() {
		return "ShippingInfomartion [id=" + id + ", shppingNumber=" + shppingNumber + ", purchase=" + purchase
				+ ", member=" + member + ", method=" + method + ", duration=" + duration + ", complete=" + complete
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof ShippingInfomartion)) return false;
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
