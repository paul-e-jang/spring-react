package bashpound.marketplace.services.cart;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		purchase.setPurchased(addCartDTO.isPurchase());
		purchaseMapper.insert(purchase, addCartDTO.getUid());
		int tx = cartMapper.insert(addCartDTO.getPid(), purchase.getId(), addCartDTO.getNumberOfItems());
		return tx == 1;
		}catch(Exception e) {
			throw e;
		}
	}

}
