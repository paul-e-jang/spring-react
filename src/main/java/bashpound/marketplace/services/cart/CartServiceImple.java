package bashpound.marketplace.services.cart;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bashpound.marketplace.infra.repository.PurchaseMapper;

@Service
public class CartServiceImple implements CartService {
	
	@Autowired
	private PurchaseMapper purchaseMapper;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public boolean processRegister(Long pid, String uid, int numberOfItems) {
		return false;
	}

}
