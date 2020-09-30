package bashpound.marketplace.domain.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin extends AbstractBaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2602879008473523870L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "admin_Name", unique = true)
	private String adminName;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "password", unique = true)
	private String password;
	
	@Column(name = "level", unique = true)
	private String level;

	@Column(name = "role", unique = true)
	private String role;
	
	
	public Admin () {
		
	}
	
	public static Admin Create(String adminName, String name, String password, String level, String role) {
		Admin admin = new Admin();
		admin.adminName = adminName;
		admin.name = name;
		admin.password = password;
		admin.level = level;
		admin.role = role;
		return admin;
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Admin)) return false;
	    Admin o1 = (Admin) o;
	    return Objects.equals(id, o1.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Admin{" +
			      "id=" + id +
			      ", name='" + name + '\'' +
			      ", password='" + password + '\'' +
			      ", level='" + level + '\'' +
			      ", role='" + role + '\'' +
			      ", adminName='" + adminName + '\'' +
			      '}';
	}

}
