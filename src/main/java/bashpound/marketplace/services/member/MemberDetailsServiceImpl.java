package bashpound.marketplace.services.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.domain.model.MemberDetails;
import bashpound.marketplace.infra.repository.MemberMapper;
import bashpound.marketplace.services.member.exception.DuplicateMemberException;

@Service
public class MemberDetailsServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberMapper
						.selectByUsername(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(member.getRole()));
		
		MemberDetails memberDetails = new MemberDetails(member,roles);
		return memberDetails;
	}

	@Override
	public Member processRegister(Member memberDto) {

		Member member = memberMapper.selectByUsername(memberDto.getUsername());
		if(member != null) {
			throw new DuplicateMemberException("이미 존재하는 이름 입니다. "+memberDto.getUsername());
		}
		// 계정 등록
		if(memberMapper.insert(memberDto) == 1) {
			member = memberMapper.selectByUsername(memberDto.getUsername());
		}
		return member;
	}
	
	@Override
	public Member selectByUsername(String username) {
		return memberMapper.selectByUsername(username);
	}
	
	@Override
	public void regDelivery(Delivery delivery) {
		memberMapper.regDelivery(delivery);
	}
}
