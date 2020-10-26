package bashpound.marketplace.services.cart.util;

public class AddCartDTO {
	private Long pid;
	private int numberOfItems;
	private String uid;
	private boolean purchase;

	@Override
	public String toString() {
		return "AddCartDTO [pid=" + pid + ", numberOfItems=" + numberOfItems + ", uid=" + uid + ", purchase="
				+ purchase + "]";
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public boolean isPurchase() {
		return purchase;
	}
	
	public void setPurchase(boolean purchase) {
		this.purchase = purchase;
	}

}
