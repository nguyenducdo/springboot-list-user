package training.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import training.entity.UserEntity;
import training.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserAPI {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserEntity> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public UserEntity findOne(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@PostMapping
	public UserEntity regist(@RequestBody UserEntity model) {
		return userService.regist(model);
	}
	
	@PutMapping("/{id}")
	public UserEntity update(@RequestBody UserEntity model, @PathVariable("id") Long id) {
		model.setId(id);
		return userService.update(model);
	}
}
