package bashpound.marketplace.apis;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.domain.model.Product;
import bashpound.marketplace.services.member.MemberService;
import bashpound.marketplace.services.product.ProductService;

//김종찬 작성
@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	@Qualifier("productServiceImpl")	
	ProductService ps;
	
	@Autowired
	@Qualifier("memberDetailsServiceImpl")
	MemberService ms;
	
	@RequestMapping(value = "/ProductRegister", method=RequestMethod.POST)
	public void productRegister(@RequestBody Map<String, Object> param) {
		Product product = new Product();
		product.setName((String)param.get("productName"));
		product.setThumbNail((String)param.get("thumbImage"));
		product.setStock(Integer.parseInt((String)param.get("stock")));
		product.setPrice(Integer.parseInt((String)param.get("price")));
		product.setCategory((String)param.get("category"));
		Member member = ms.selectByUsername((String)param.get("username"));
		System.out.println(product);
		ps.productRegister(product);
	}
	
	@RequestMapping(value = "/fileupload", method=RequestMethod.POST)
	public void fileupload(MultipartFile file) {
		String uploadFolder = "classpath:/upload";
		File uploadPath = new File(uploadFolder, "$username/$product");
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		try {
			FileOutputStream fos = new FileOutputStream(new File(uploadPath, fileName));
			fos.write(file.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
