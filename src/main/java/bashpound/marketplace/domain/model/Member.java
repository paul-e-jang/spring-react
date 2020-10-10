package bashpound.marketplace.domain.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Member {
	@NotBlank(message = "공백은 허용하지 않습니다.")
	private String username;
	@Email(message = "이메일 규격에 맞지 않습니다.")
	private String emailAddress;
	@Size(min = 8, max = 20, message = "암호는 8자에서 20자 사이입니다.")
	@NotBlank(message = "공백은 허용하지 않습니다.")
	private String password;
	private String gender;
	private Date birth;
	@Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$")
	private String phone;
	private Date enrollDate;
	private boolean seller;
	private int levels;
	private boolean delFlag;
	private String role;
	private Date delDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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

	@Override
	public String toString() {
		return "Member [  username=" + username + ", emailAddress=" + emailAddress + ", password=" + password
				+ ", gender=" + gender + ", birth=" + birth + ", phone=" + phone + ", enrollDate=" + enrollDate
				+ ", seller=" + seller + ", levels=" + levels + ", delFlag=" + delFlag + ", role=" + role + ", delDate="
				+ delDate + "]";
	}

}
