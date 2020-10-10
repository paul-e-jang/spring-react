package bashpound.marketplace.services.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bashpound.marketplace.domain.model.Product;
import bashpound.marketplace.infra.repository.ProductMapper;

@Service
//@Primary
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper pm;
	
	@Override
	public void productRegister(Product product) {
		pm.productRegister(product);
	}

	@Override
	public List<Product> listProductAll() {
		return pm.listProductAll();
	}

	@Override
	public List<Product> searchProduct(String key) {
		return pm.searchProduct(key);
	}

	@Override
	public Map<String, String> productDetail(Long productId) {
		return pm.productDetail(productId);
	}
	
}
