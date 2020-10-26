package bashpound.marketplace.infra.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Cart;

public interface CartMapper {

	public List<Cart> getCart(@Param("username") String username);

	public int insert(@Param("prodId") Long pid, @Param("purchaseId") int purchaseId,
			@Param("numberOfItems") int numberOfItems);

}
