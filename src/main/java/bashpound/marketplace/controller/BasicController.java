package bashpound.marketplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class BasicController {
	@RequestMapping(value="/pullrequest")
	public String pullRequest() {
		String param1 = "이름";
		String value1 = "김종찬";
		JsonObject json = new JsonObject();
		json.addProperty(param1, value1);
		return json.toString();
	}
}
