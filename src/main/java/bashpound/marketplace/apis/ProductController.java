package bashpound.marketplace.apis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bashpound.marketplace.domain.model.Product;
import bashpound.marketplace.services.product.ProductService;

//김종찬 작성
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	@Qualifier("productServiceImpl")
	ProductService ps;
	
	@RequestMapping(value = "/ProductRegister", method=RequestMethod.POST)
	public void productRegister(Product product) {
		ps.productRegister(product);
	}
	
	@RequestMapping(value = "/listProductAll", method=RequestMethod.GET)
	public List<Product> listAll(){
		return ps.listProductAll();
	}
	
	@RequestMapping(value = "/SearchResult", method=RequestMethod.GET)
	public List<Product> searchProduct(@RequestParam("key") String key) {
		return ps.searchProduct(key);
	}
	
	@RequestMapping(value = "/details/{productId}", method=RequestMethod.GET)
	public Map<String, String> productDetail(@PathVariable Long productId) {
		return ps.productDetail(productId);
	}
	
}
