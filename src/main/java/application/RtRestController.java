package application;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RtRestController {

	// inject via application.properties
		@Value("${welcome.message:test}")
		private String message = "Hello World";
		
	@RequestMapping("/rtflowcheck")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "rtflowcheck";
	}
}
