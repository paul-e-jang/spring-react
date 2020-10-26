package bashpound.marketplace.services.cart;

import bashpound.marketplace.services.cart.util.AddCartDTO;

public interface CartService {
	public boolean processRegister(AddCartDTO addCartDTO);
}
