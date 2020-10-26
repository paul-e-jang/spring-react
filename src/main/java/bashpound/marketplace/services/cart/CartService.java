package bashpound.marketplace.services.cart;

public interface CartService {
	public boolean processRegister(Long pid, String uid, int numberOfItems);
}
