package bashpound.marketplace.domain.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private Gender gender;
	@Column(name = "birth", nullable = true)
	private Date birth;
	@Column(name = "phone", nullable = true)
	private String phone;
	@Column(name = "enrollDate", nullable = true)
	private Date enrollDate;
	@Column(name = "seller", nullable = true)
	private boolean seller;
	@Column(name = "level", nullable = true)
	private int level;
	@Column(name = "delFlag", nullable = true)
	private boolean delFlag;
	@Column(name = "delDate", nullable = true)
	private Date delDate;
	@Column(name = "role")
	private String role;
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
				+ ", seller=" + seller + ", level=" + level + ", delFlag=" + delFlag + ", delDate=" + delDate
				+ ", role=" + role + ", complains=" + complains + "]";
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Complain> getComplains() {
		return complains;
	}

	public void setComplains(List<Complain> complains) {
		this.complains = complains;
	}

}
