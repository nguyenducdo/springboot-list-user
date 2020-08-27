package training.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.model.UserModel;
import training.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping
	public UserModel login(@RequestBody UserModel model) {
		return authService.login(model.getUsername(), model.getPassword());
	}
}
