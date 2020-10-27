package bashpound.marketplace.services.cart;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bashpound.marketplace.domain.model.Cart;
import bashpound.marketplace.domain.model.Purchase;
import bashpound.marketplace.infra.repository.CartMapper;
import bashpound.marketplace.infra.repository.PurchaseMapper;
import bashpound.marketplace.services.cart.util.AddCartDTO;

@Service
public class CartServiceImple implements CartService {

	@Autowired
	private PurchaseMapper purchaseMapper;

	@Autowired
	private CartMapper cartMapper;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public boolean processRegister(AddCartDTO addCartDTO) {
		try {
			Purchase purchase = new Purchase();
			purchase.setPurchased(addCartDTO.isPurchased());
			purchaseMapper.insert(purchase, addCartDTO.getUid());
			int tx = cartMapper.insert(addCartDTO.getPid(), purchase.getId(), addCartDTO.getNumberOfItems());
			return tx == 1;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Cart> processGetCartOrPurchase(AddCartDTO addCartDTO) {
		return cartMapper.getCart(addCartDTO);
	}

	@Override
	public void processCheckOut(AddCartDTO addCartDTO) {
		int result = purchaseMapper.updateAll(addCartDTO);
		return;
	}

	@Override
	public void processDeleteFromCart(AddCartDTO addCartDTO) {
		cartMapper.deleteByUidAndPid(addCartDTO);
		return;
	}

	@Override
	public void processUpdateQtyFromCart(AddCartDTO addCartDTO) {
		cartMapper.updateQtyByPidAndUid(addCartDTO);
		return;
	}

}
