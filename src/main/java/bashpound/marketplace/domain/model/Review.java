package bashpound.marketplace.domain.model;

import java.util.Date;
import java.util.Objects;

//김종찬 작성
public class Review {
	private Long id;
	//private Product product; 1:N구조에서 1인 Product에서 관리
	//private Member reviewer; 1:N구조에서 1인 Member에서 관리
	private String thumbNail;
	private int score;
	private Date regDate;
	private String content;
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", thumbNail=" + thumbNail
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
