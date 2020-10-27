package bashpound.marketplace.services.cart.util;

public class AddCartDTO {
	private Long pid;
	private int numberOfItems;
	private int qty;
	private String uid;
	private boolean purchased;

	@Override
	public String toString() {
		return "AddCartDTO [pid=" + pid + ", numberOfItems=" + numberOfItems + ", qty=" + qty + ", uid=" + uid
				+ ", purchased=" + purchased + "]";
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

}
