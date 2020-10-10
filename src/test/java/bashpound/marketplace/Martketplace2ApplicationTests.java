package bashpound.marketplace;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.infra.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Martketplace2Application.class)
@RunWith(SpringRunner.class)
class Martketplace2ApplicationTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testRepository() {
		try {
		Member member  = memberMapper.selectByUsername("doli0413");
		System.out.println("================================\n"+member);
		System.out.println("================================");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
