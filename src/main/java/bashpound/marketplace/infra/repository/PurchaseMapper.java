package bashpound.marketplace.infra.repository;


import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Purchase;

public interface PurchaseMapper {
	public int insert(@Param("purchase")Purchase purchase,@Param("username")String uid);
}
