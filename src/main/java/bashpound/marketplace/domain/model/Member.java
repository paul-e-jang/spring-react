package bashpound.marketplace.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import bashpound.marketplace.utils.Gender;

@Entity
@Table(name = "Member")
public class Member extends AbstractBaseEntity {

	private static final long serialVersionUID = -6918840496309520343L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "username", unique = true)
	private String username;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "gender", nullable = true)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "birth", nullable = true)
	private Date birth;
	@Column(name = "phone", nullable = true)
	private String phone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enrollDate", nullable = true)
	private Date enrollDate;

	@Column(name = "is_seller", nullable = true, columnDefinition = "number(1) default 0")
	private boolean seller;
	@Column(name = "levels", nullable = true, columnDefinition = "number(1) default 0")
	private int levels;
	@Column(name = "delFlag", nullable = true, columnDefinition = "number(1) default 0")
	private boolean delFlag;
	@Column(name = "role", columnDefinition = "char(10) default 'ROLE_USER'")
	private String role;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delDate", nullable = true)
	private Date delDate;
	@OneToMany(mappedBy = "seller")
	private List<Product> products = new ArrayList<>();
	@OneToMany(mappedBy = "member")
	private List<Complain> complains = new ArrayList<>();
	@OneToMany(mappedBy = "member")
	private List<Purchase> purcahses = new ArrayList<>();
	@OneToMany(mappedBy = "reviewer")
	private List<Review> reviews = new ArrayList<>();
	@OneToMany(mappedBy = "member")
	private List<ShippingInfomartion> shippingInformations = new ArrayList<>();

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", birth=" + birth + ", phone=" + phone + ", enrollDate=" + enrollDate
				+ ", seller=" + seller + ", levels=" + levels + ", delFlag=" + delFlag + ", delDate=" + delDate
				+ ", complains=" + complains + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public boolean isSeller() {
		return seller;
	}

	public void setSeller(boolean seller) {
		this.seller = seller;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Complain> getComplains() {
		return complains;
	}

	public void setComplains(List<Complain> complains) {
		this.complains = complains;
	}

	public List<Purchase> getPurcahses() {
		return purcahses;
	}

	public void setPurcahses(List<Purchase> purcahses) {
		this.purcahses = purcahses;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<ShippingInfomartion> getShippingInformations() {
		return shippingInformations;
	}

	public void setShippingInformations(List<ShippingInfomartion> shippingInformations) {
		this.shippingInformations = shippingInformations;
	}

}
