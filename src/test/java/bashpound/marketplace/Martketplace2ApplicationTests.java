package bashpound.marketplace;


import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.infra.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class Martketplace2ApplicationTests {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void testRepository() {
		Optional<Member> member = memberRepository.findByUsername("doli0413");
		System.out.println(member.get());
	}
}
