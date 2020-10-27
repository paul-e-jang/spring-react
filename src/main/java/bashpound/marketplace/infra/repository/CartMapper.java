package bashpound.marketplace.infra.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Cart;
import bashpound.marketplace.services.cart.util.AddCartDTO;

public interface CartMapper {

	public List<Cart> getCart(@Param("addCartDTO") AddCartDTO addCartDTO);

	public int insert(@Param("prodId") Long pid, @Param("purchaseId") Long purchaseId,
			@Param("numberOfItems") int numberOfItems);

	public void deleteByUidAndPid(AddCartDTO addCartDTO);

	public void updateQtyByPidAndUid(AddCartDTO addCartDTO);

}
