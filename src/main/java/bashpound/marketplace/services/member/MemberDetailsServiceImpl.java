package bashpound.marketplace.services.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.domain.model.MemberDetails;
import bashpound.marketplace.infra.mapper.MemberMapper;
import bashpound.marketplace.infra.repository.MemberRepository;

@Service
public class MemberDetailsServiceImpl implements MemberService{
	
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberRepository
						.findByUsername(username)
						.orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(member.getRole()));
		
		MemberDetails memberDetails = new MemberDetails(member,roles);
		return memberDetails;
	}

	@Override
	public bashpound.marketplace.domain.model.mybatis.Member processRegister(
			bashpound.marketplace.domain.model.mybatis.Member memberDto) {
		bashpound.marketplace.domain.model.mybatis.Member member = memberMapper.selectByUsername(memberDto.getUsername());
		System.out.println(member);
		return null;
	}

	

}
