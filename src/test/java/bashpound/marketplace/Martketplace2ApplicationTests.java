package bashpound.marketplace;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.domain.model.Purchase;
import bashpound.marketplace.infra.repository.DeliveryMapper;
import bashpound.marketplace.infra.repository.MemberMapper;
import bashpound.marketplace.infra.repository.PurchaseMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Martketplace2Application.class)
@RunWith(SpringRunner.class)
class Martketplace2ApplicationTests {

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private DeliveryMapper deliveryMapper;

	@Autowired
	private PurchaseMapper purchaseMapper;

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

	@Test
	public void testPurchaseJoin() {
		List<Purchase> list = purchaseMapper.selectJoin("doli0413");
		list.forEach(purc -> System.out.println(purc));
	}
}
