package bashpound.marketplace.apis;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bashpound.marketplace.domain.model.Delivery;
import bashpound.marketplace.services.delivery.DeliveryService;
import bashpound.marketplace.utils.Message;

@Controller
public class DeliveryController {
	
	private DeliveryService deliveryService;
	
	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	@RequestMapping(value = "/api/delivery",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> deliveryRegister(@RequestBody Delivery delivery) {
		try {
		boolean result = deliveryService.processRegister(delivery);
		}catch(Exception e) {
			return new ResponseEntity<Object>(new Message.Builder(e.getMessage()).build(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
