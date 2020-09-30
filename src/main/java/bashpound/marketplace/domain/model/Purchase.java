package bashpound.marketplace.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Purchase")
public class Purchase extends AbstractBaseEntity {

	private static final long serialVersionUID = 3529842743009258711L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "orderNumber", unique = true)
	private String orderNumber;
	@ManyToOne
	@JoinColumn(name = "Member_username")
	private Member member;
	@ManyToOne
	@JoinColumn(name = "Product_ProdNumber")
	private Product product;
	@Column(name = "purchaseDate")
	private Date purchaseDate;
	@Column(name = "arrive")
	private boolean arrive;
	@OneToMany(mappedBy = "purchase")
	private List<ShippingInfomartion> shippingInformations = new ArrayList<>();

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", orderNumber=" + orderNumber + ", member=" + member + ", product=" + product
				+ ", purchaseDate=" + purchaseDate + ", arrive=" + arrive + ", shippingInformations="
				+ shippingInformations + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Purchase)) return false;
	    Purchase o1 = (Purchase) o;
	    return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public List<ShippingInfomartion> getShippingInformations() {
		return shippingInformations;
	}

	public void setShippingInformations(List<ShippingInfomartion> shippingInformations) {
		this.shippingInformations = shippingInformations;
	}

}
