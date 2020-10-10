package bashpound.marketplace.domain.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

//김종찬 작성
public class Product {
	private Long id;
	private String prodNumber;
	private String name;
	private String thumbNail;
	private Member seller;
	private Date regDate;
	private int stock;
	private String price;
	private String options;
	private String category;
	private List<MapPurchaseProd> purchases;
	private List<Review> reviews;

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodNumber=" + prodNumber + ", name=" + name + ", thumbNail=" + thumbNail
				+ ", seller=" + seller + ", regDate=" + regDate + ", stock=" + stock + ", price=" + price + ", options="
				+ options + ", category=" + category + ", purchases=" + purchases + ", reviews=" + reviews + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Product))
			return false;
		Product o1 = (Product) o;
		return Objects.equals(id, o1.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProdNumber() {
		return prodNumber;
	}

	public void setProdNumber(String prodNumber) {
		this.prodNumber = prodNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	public Member getSeller() {
		return seller;
	}

	public void setSeller(Member seller) {
		this.seller = seller;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<MapPurchaseProd> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<MapPurchaseProd> purchases) {
		this.purchases = purchases;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}
