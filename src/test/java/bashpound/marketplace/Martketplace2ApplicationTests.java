package bashpound.marketplace;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import bashpound.marketplace.infra.repository.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = Martketplace2Application.class)
@RunWith(SpringRunner.class)
@Transactional
class Martketplace2ApplicationTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testRepository() {
	}
}
