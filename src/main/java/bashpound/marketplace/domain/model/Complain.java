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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Complain")
public class Complain extends AbstractBaseEntity {

	private static final long serialVersionUID = 2299927871539111066L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "Member_username")
	private Member member;
	@Column(name = "complain")
	private String complain;
	@Column(name = "regDate")
	private Date regDate;
	@Column(name = "answer")
	private String answer;
	
	@Temporal(TemporalType.TIMESTAMP)
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Complain)) return false;
	    Complain o1 = (Complain) o;
	    return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
