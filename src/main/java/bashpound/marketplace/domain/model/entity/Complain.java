package bashpound.marketplace.domain.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Complain")
public class Complain implements Serializable {

	private static final long serialVersionUID = 2299927871539111066L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "Member_username")
	private Member member;
	@Column(name = "complain")
	private String complain;
	@Column(name = "regDate")
	private Date regDate;
	@Column(name = "answer")
	private String answer;
	@Column(name = "ansDate")
	private Date ansDate;
	@Column(name = "ansFlag")
	private boolean ansFlag;

	@Override
	public String toString() {
		return "Complain [id=" + id + ", member=" + member + ", complain=" + complain + ", regDate=" + regDate
				+ ", answer=" + answer + ", ansDate=" + ansDate + ", ansFlag=" + ansFlag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complain other = (Complain) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

	public boolean isAnsFlag() {
		return ansFlag;
	}

	public void setAnsFlag(boolean ansFlag) {
		this.ansFlag = ansFlag;
	}

}
