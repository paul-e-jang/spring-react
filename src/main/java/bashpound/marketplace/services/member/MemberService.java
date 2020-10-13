package bashpound.marketplace.services.member;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import bashpound.marketplace.config.security.AuthenticationToken;
import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.domain.model.Member;
import bashpound.marketplace.domain.model.Product;


public interface MemberService extends UserDetailsService {

	Member processRegister(Member memberDto);

	Member selectByUsername(String username);
	
	void regDelivery(Delivery delivery);

	boolean processSellerUpdate(AuthenticationToken authenticationToken);

	List<Product> processGetCart(String username);

}
