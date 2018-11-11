package narif.pocs.coolspablog.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://localhost:4200/",allowCredentials="false")
@RestController
public class WelcomePageController {
	
	@RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
	
	@RequestMapping(value="/j_spring_security_logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "{}";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
	
	@GetMapping("/api")
	public Map<String, Object> getTheWelcomeNotes(){
		Map<String, Object> model = new HashMap<>();
		model.put("id",UUID.randomUUID().toString());
		model.put("content", "Welcome to the coolest SPA Blog site ever");
		return model;
	}

}
