package narif.pocs.coolspablog.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://localhost:4200/",allowCredentials="false")
@RestController("/api")
public class WelcomePageController {
	
	@GetMapping
	public Map<String, Object> getTheWelcomeNotes(){
		Map<String, Object> model = new HashMap<>();
		model.put("id",UUID.randomUUID().toString());
		model.put("content", "Welcome to the coolest SPA Blog site ever");
		return model;
	}

}
