package bashpound.marketplace.services.cart;

import java.util.List;

import bashpound.marketplace.domain.model.Cart;
import bashpound.marketplace.services.cart.util.AddCartDTO;

public interface CartService {
	public boolean processRegister(AddCartDTO addCartDTO);

	public List<Cart> processGetCartOrPurchase(AddCartDTO addCartDTO);

	public void processCheckOut(AddCartDTO addCartDTO);

	public void processDeleteFromCart(AddCartDTO addCartDTO);

	public void processUpdateQtyFromCart(AddCartDTO addCartDTO);
}
