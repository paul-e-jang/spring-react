package bashpound.marketplace.apis;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.services.member.MemberService;

@Controller
public class MemberController {
	
	MemberService memberService;
	
	MemberController(MemberService memberService){
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "/api/MemberRegister", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public ResponseEntity Register(@Valid @RequestBody Member memberDto, Errors errors) {
		System.out.println(memberDto);
		
		if(errors.hasErrors()) {
			errors.getFieldErrors().forEach(err -> System.out.println(err));
			return null;
		}
		Member member = memberService.processRegister(memberDto);
		
		
		return null;
	}
	
}
