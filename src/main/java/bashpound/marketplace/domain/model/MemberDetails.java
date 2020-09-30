package bashpound.marketplace.domain.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MemberDetails extends User {


	private static final long serialVersionUID = -6737031506498286571L;
	
	private Member member;

	public MemberDetails(Member member, Collection<? extends GrantedAuthority> authorities) {
		super(member.getUsername(), member.getPassword(), authorities);
		this.member = member;
	}	
	
	public Member getMember() {
		return member;
	}

}
