package training.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import training.model.UserModel;
import training.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserAPI {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserModel> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public UserModel findOne(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@PostMapping
	public UserModel regist(@Valid @RequestBody UserModel model) {
		return userService.regist(model);
	}
	
	@PutMapping("/{id}")
	public UserModel update(@Valid @RequestBody UserModel model, @PathVariable("id") Long id) {
		model.setId(id);
		return userService.update(model);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}
