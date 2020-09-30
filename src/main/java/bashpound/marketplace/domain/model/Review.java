package bashpound.marketplace.domain.model;

import java.sql.Date;
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
@Table(name = "Review")
public class Review extends AbstractBaseEntity {

	private static final long serialVersionUID = -3568616019123152027L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "Product_ProdNumber")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "Member_username")
	private Member reviewer;
	@Column(name = "thumbNail")
	private String thumbNail;
	@Column(name = "score")
	private int score;
	@Column(name = "regDate")
	private Date regDate;
	@Column(name = "content")
	private String content;

	@Override
	public String toString() {
		return "Review [id=" + id + ", product=" + product + ", reviewer=" + reviewer + ", thumbNail=" + thumbNail
				+ ", score=" + score + ", regDate=" + regDate + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Review)) return false;
	    Review o1 = (Review) o;
	    return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getReviewer() {
		return reviewer;
	}

	public void setReviewer(Member reviewer) {
		this.reviewer = reviewer;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
