package bashpound.marketplace.services.delivery;

import java.util.List;

import org.springframework.stereotype.Service;

import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.infra.repository.DeliveryMapper;
import bashpound.marketplace.services.delivery.exception.DuplicateAddressException;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	private DeliveryMapper deliveryMapper;
	
	public DeliveryServiceImpl(DeliveryMapper deliveryMapper) {
		this.deliveryMapper = deliveryMapper;
	}

	@Override
	public boolean processRegister(Delivery delivery) {
		List<Delivery> deliveryCheck = deliveryMapper.select(delivery.getMember().getUsername());
		
		
		deliveryCheck.forEach(dely -> {
			if(dely.getAddress2().equals(delivery.getAddress2())) {
				throw new DuplicateAddressException("이미 등록된 주소 입니다.");
			} else if(dely.isMainAddress() == delivery.isMainAddress()) {
				throw new DuplicateAddressException("메인 주소는 하나여야합니다.");
			}
		});
		
		int result = 0;
		try {
			result = deliveryMapper.insert(delivery);
		}catch(Exception e) {
			throw e;
		}
		return result == 1;
	}

}
