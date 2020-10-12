package bashpound.marketplace.services.product;

import java.util.List;
import java.util.Map;

import bashpound.marketplace.domain.model.Product;

public interface ProductService {
	
	public void productRegister(Product product);
	
	public List<Product> listProductAll();

	public List<Product> searchProduct(String category, String key);

	public Map<String, String> productDetail(Long productId);

	
}
