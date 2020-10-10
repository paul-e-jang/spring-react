package bashpound.marketplace.apis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
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
import bashpound.marketplace.utils.Message;

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
			Map<String,String> errMap = new HashMap<>();
			 errors.getAllErrors().stream().forEach(err -> {
				 String errArr =  err.getCodes()[0]; 
				 String msg =errArr.substring(errArr.lastIndexOf(".")+1,errArr.length());
				 System.out.println(msg + "/ "+ err.getDefaultMessage());
				 errMap.put(msg, err.getDefaultMessage());
			 });
			return new ResponseEntity<Map>(errMap,HttpStatus.BAD_REQUEST);
		}
		Member member;
		try {
		member = memberService.processRegister(memberDto);
		}catch(Exception e) {
			Message message = new Message.Builder(e.getMessage()).build();
			return new ResponseEntity<Message>(message,HttpStatus.CONFLICT);
		}
		
		
		return new ResponseEntity<Member>(member,HttpStatus.OK);
	}
	
}
