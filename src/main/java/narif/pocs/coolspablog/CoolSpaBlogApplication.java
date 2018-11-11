package narif.pocs.coolspablog;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/resource")
public class CoolSpaBlogApplication {
	
	@GetMapping
	public Map<String, Object> getTheWelcomeNotes(){
		Map<String, Object> model = new HashMap<>();
		model.put("id",UUID.randomUUID().toString());
		model.put("content", "Welcome to the coolest SPA Blog site ever");
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(CoolSpaBlogApplication.class, args);
	}
}
