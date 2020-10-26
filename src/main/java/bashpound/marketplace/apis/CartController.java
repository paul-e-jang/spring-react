package bashpound.marketplace.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bashpound.marketplace.services.cart.CartService;

@RestController
@RequestMapping("/api/**")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/addToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> addToCart(@RequestParam("pid") Long pid, @RequestParam("uid") String uid,
			@RequestParam("numberOfItems") int numberOfItems) {
		return null;
	}

}
