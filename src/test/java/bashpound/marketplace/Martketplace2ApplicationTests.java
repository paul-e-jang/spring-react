package bashpound.marketplace;

import java.io.File;
import java.util.ArrayList;
import java.util.List;import java.util.concurrent.ExecutionException;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import bashpound.marketplace.domain.model.Cart;
import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.domain.model.Product;
import bashpound.marketplace.domain.model.Purchase;
import bashpound.marketplace.infra.repository.CartMapper;
import bashpound.marketplace.infra.repository.DeliveryMapper;
import bashpound.marketplace.infra.repository.MemberMapper;
import bashpound.marketplace.infra.repository.ProductMapper;
import bashpound.marketplace.infra.repository.PurchaseMapper;
import junit.framework.Assert;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Martketplace2Application.class)
@RunWith(SpringRunner.class)
class Martketplace2ApplicationTests {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Martketplace2ApplicationTests.class);

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private DeliveryMapper deliveryMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Autowired
	private CartMapper cartMapper;
	
	@Test
	public void testTx() {
		Purchase purchase = new Purchase();
		try {
		int i = purchaseMapper.insert(purchase, "jchan");
		LOGGER.warn(String.valueOf(purchase.getId()));
		// 11개 수량 넘겨받은 아이디 
		int k = cartMapper.insert(9L, purchase.getId(), 11);
		LOGGER.warn(String.valueOf(k));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testCartMapper() {
		List<Cart> list = cartMapper.getCart("jchan");
		
		list.forEach(i -> LOGGER.info(i.getUsername()+" / "+i.getProdName()+" / "+i.getQuantity()+" / "+i.getSellerName()+" / "+i.getStock()+" / "+i.getProdRegdate()+" / "+i.getPurchaseDate()));
	}
	
//	@Test
	public void testRepository() {
		try {
			Member member = memberMapper.selectByUsername("doli0413");
			System.out.println("================================\n" + member);
			System.out.println("================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void isLocated() {
		try {
			ClassPathResource classPathResource = new ClassPathResource("application.properties");
			System.out.println("================================");
			String filePath = classPathResource.getFile().getAbsolutePath().toString();
			System.out.println(filePath);
			String resouceDir = filePath.substring(0, filePath.lastIndexOf("\\"));
			String dir = resouceDir + "\\upload";
			File file = new File(dir);
			file.mkdir();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
	public void testCuration() {
		List<Product> list = productMapper.selectCuration(1);
		list.forEach( cur -> System.out.println(cur));
	}
}
