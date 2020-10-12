package bashpound.marketplace.services.delivery;

import bashpound.marketplace.domain.model.Delivery;

public interface DeliveryService {
	public boolean processRegister(Delivery delivery);
}
