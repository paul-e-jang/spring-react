package bashpound.marketplace;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.infra.repository.DeliveryMapper;
import bashpound.marketplace.infra.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Martketplace2Application.class)
@RunWith(SpringRunner.class)
class Martketplace2ApplicationTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private DeliveryMapper deliveryMapper;
	
//	@Test
	public void testRepository() {
		try {
		Member member  = memberMapper.selectByUsername("doli0413");
		System.out.println("================================\n"+member);
		System.out.println("================================");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void isExist() {
		try {
			List<Delivery> result = deliveryMapper.select("doli0413");
		System.out.println("====================================");
		result.forEach(deli -> System.out.println(deli));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
