package bashpound.marketplace.infra.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import bashpound.marketplace.domain.model.Product;

public interface ProductMapper {

	public void productRegister(Product product);

	public List<Product> listProductAll();

	public List<Product> searchProduct(String category, String key);

	public Map<String, String> productDetail(Long productId);
}
