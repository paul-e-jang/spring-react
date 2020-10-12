package bashpound.marketplace.infra.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Delivery;

public interface DeliveryMapper {
	public String getNow();

	public int insert(@Param("delivery")Delivery delivery);

	public List<Delivery> select(@Param("username")String username);
}
