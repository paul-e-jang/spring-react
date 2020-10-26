package bashpound.marketplace.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import bashpound.marketplace.services.cart.CartService;
import bashpound.marketplace.services.cart.util.AddCartDTO;
import bashpound.marketplace.utils.Message;

@RestController
@RequestMapping("/api/**")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/addToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> addToCart(@RequestBody AddCartDTO addCartDTO) {
		try {
		boolean result = cartService.processRegister(addCartDTO);
		System.out.println(result);
		return new ResponseEntity<Object>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(new Message.Builder(e.getMessage()).build(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/purchase",consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public ResponseEntity<Object> buyProductNow(@RequestBody AddCartDTO addCartDTO){
		System.out.println(addCartDTO);
		try {
			boolean result = cartService.processRegister(addCartDTO);
			System.out.println(result);
			return new ResponseEntity<Object>(HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<Object>(new Message.Builder(e.getMessage()).build(),HttpStatus.BAD_REQUEST);
			}
	}

}
