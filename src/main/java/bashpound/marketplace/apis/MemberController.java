package bashpound.marketplace.apis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.services.member.MemberService;

@Controller
public class MemberController {
	
	MemberService memberService;
	
	MemberController(MemberService memberService){
		this.memberService = memberService;
	}
	
}
