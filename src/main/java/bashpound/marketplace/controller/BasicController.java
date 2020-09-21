package bashpound.marketplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class BasicController {

	@RequestMapping(value = "/pullrequest")
	public String basicController() {
		String param1 ="이름";
		String value1 = "정수민";
		
		JsonObject jsonObject = new JsonObject();
		
		jsonObject.addProperty(param1, value1);
		
		return jsonObject.toString();
	}
}
