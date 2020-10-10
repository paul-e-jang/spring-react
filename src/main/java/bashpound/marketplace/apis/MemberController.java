package bashpound.marketplace.apis;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bashpound.marketplace.domain.model.Delivery;
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
	
	//김종찬 추가
	@RequestMapping("/api/getMember")
	@ResponseBody
	public Member selectByUsername(@RequestParam("username") String username) {
		System.out.println(username);
		return memberService.selectByUsername(username);
	}
	
	//김종찬 추가
	@RequestMapping(value="/api/delivery", method=RequestMethod.POST)
	@ResponseBody
	public void regDelivery(@RequestBody Map<String, Object> param) {
		Member member = memberService.selectByUsername((String)param.get("username"));
		Delivery delivery = new Delivery();
		delivery.setMember(member);
		delivery.setZipcode((String)param.get("zipcode"));
		delivery.setNameOfDelivery((String)param.get("name_of_delivery"));
		delivery.setAddress1((String)param.get("address1"));
		delivery.setAddress2((String)param.get("address2"));
		delivery.setMainAddress((boolean)param.get("is_main_address"));
		System.out.println(delivery);
		memberService.regDelivery(delivery);
	}
	
}
