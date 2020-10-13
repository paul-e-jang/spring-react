package bashpound.marketplace.apis;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bashpound.marketplace.config.security.AuthenticationToken;
import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.services.member.MemberService;
import bashpound.marketplace.utils.Message;

@Controller
public class MemberController {

	MemberService memberService;

	MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/api/MemberRegister", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity Register(@Valid @RequestBody Member memberDto, Errors errors) {

		if (errors.hasErrors()) {
			Map<String, String> errMap = new HashMap<>();
			errors.getAllErrors().stream().forEach(err -> {
				String errArr = err.getCodes()[0];
				String msg = errArr.substring(errArr.lastIndexOf(".") + 1, errArr.length());
				errMap.put(msg, err.getDefaultMessage());
			});
			return new ResponseEntity<Map>(errMap, HttpStatus.BAD_REQUEST);
		}
		Member member;
		try {
			member = memberService.processRegister(memberDto);
		} catch (Exception e) {
			Message message = new Message.Builder(e.getMessage()).build();
			return new ResponseEntity<Message>(message, HttpStatus.CONFLICT);
		}

		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/registerSeller", method = RequestMethod.POST)
	public ResponseEntity registerSeller() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication instanceof AnonymousAuthenticationToken) {

		}
		AuthenticationToken authenticationToken = (AuthenticationToken)authentication;
		boolean result = memberService.processSellerUpdate(authenticationToken);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/fetchUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> loadUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		HashMap<String, Object> resultMap = new HashMap<>();
		if(authentication instanceof AnonymousAuthenticationToken) {
			resultMap.put("username", "anonymous");
			resultMap.put("authenticate", false);
			return new ResponseEntity<HashMap<String, Object>>(resultMap,HttpStatus.OK);
		}
		Member member = (Member)((AuthenticationToken)authentication).getPrincipal();
		resultMap.put("username", member.getUsername());
		resultMap.put("authenticated", true);
		return new ResponseEntity<HashMap<String, Object>>(resultMap,HttpStatus.OK);		
	}

	@RequestMapping(value = "/api/cart/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCartList(@PathVariable("username") String username) {

		return null;
	}

	// 김종찬 추가
	@RequestMapping("/api/getMember")
	@ResponseBody
	public Member selectByUsername(@RequestParam("username") String username) {
		System.out.println(username);
		return memberService.selectByUsername(username);
	}
}
