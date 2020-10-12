package bashpound.marketplace.infra.repository;

import java.util.List;

import bashpound.marketplace.domain.model.Purchase;

public interface PurchaseMapper {
	public List<Purchase> selectJoin(String username);
}
