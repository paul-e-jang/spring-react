package bashpound.marketplace.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bashpound.marketplace.domain.model.Cart;
import bashpound.marketplace.services.cart.CartService;
import bashpound.marketplace.services.cart.util.AddCartDTO;
import bashpound.marketplace.utils.Message;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/addToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> addToCart(@RequestBody AddCartDTO addCartDTO) {
		try {
			boolean result = cartService.processRegister(addCartDTO);
			System.out.println(result);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new Message.Builder(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/purchase", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> buyProductNow(@RequestBody AddCartDTO addCartDTO) {
		System.out.println(addCartDTO);
		try {
			boolean result = cartService.processRegister(addCartDTO);
			System.out.println(result);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new Message.Builder(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> getCart(@RequestBody AddCartDTO addCartDTO) {
		try {
		List<Cart> cart = cartService.processGetCartOrPurchase(addCartDTO);
		return new ResponseEntity<Object>(cart, HttpStatus.OK);
		}catch (Exception e) {
			Message message = new Message.Builder(e.getMessage()).build();
			return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getPurchased", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> getPurchased(@RequestBody AddCartDTO addCartDTO) {
		try {
		addCartDTO.setPurchased(true);
		List<Cart> cart = cartService.processGetCartOrPurchase(addCartDTO);
		return new ResponseEntity<Object>(cart, HttpStatus.OK);
		}catch (Exception e) {
			Message message = new Message.Builder(e.getMessage()).build();
			return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/checkOut", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> checkOut(@RequestBody AddCartDTO addCartDTO) {
		try {
		cartService.processCheckOut(addCartDTO);
		}catch (Exception e) {
			Message message = new Message.Builder(e.getMessage()).build();
			return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteFromCart", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> deleteFromCart(@RequestBody AddCartDTO addCartDTO) {
		try {
		cartService.processDeleteFromCart(addCartDTO);
		}catch (Exception e) {
			Message message = new Message.Builder(e.getMessage()).build();
			return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateQtyFromCart", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> updateQtyFromCart(@RequestBody AddCartDTO addCartDTO) {
		try {
		cartService.processUpdateQtyFromCart(addCartDTO);
		}catch (Exception e) {
			Message message = new Message.Builder(e.getMessage()).build();
			return new ResponseEntity<Object>(message,HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
