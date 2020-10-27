package bashpound.marketplace.infra.repository;


import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Purchase;
import bashpound.marketplace.services.cart.util.AddCartDTO;

public interface PurchaseMapper {
	public int insert(@Param("purchase")Purchase purchase,@Param("username")String uid);
	
	public int updateAll(@Param("addCartDTO") AddCartDTO addCartDTO);
}
