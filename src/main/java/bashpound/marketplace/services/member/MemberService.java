package bashpound.marketplace.services.member;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import bashpound.marketplace.config.security.AuthenticationToken;
import bashpound.marketplace.domain.model.Cart;
import bashpound.marketplace.domain.model.Member;


public interface MemberService extends UserDetailsService {

	Member processRegister(Member memberDto);

	Member selectByUsername(String username);

	boolean processSellerUpdate(AuthenticationToken authenticationToken);

}
