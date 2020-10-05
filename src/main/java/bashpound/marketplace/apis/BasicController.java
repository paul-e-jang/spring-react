package bashpound.marketplace.apis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	
	  @GetMapping(value = { "/", "/login" })
	  public String getEntry() {
	    return "index";
	  }
}
