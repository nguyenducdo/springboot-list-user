package training.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.converter.UserConverter;
import training.entity.UserEntity;
import training.model.UserModel;
import training.repository.UserRepository;
import training.utils.AppUtil;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter converter;
	
	public UserModel login(String username, String password) {
		Optional<UserEntity> opEntity = userRepository.findByUsername(username);
		if (opEntity.isPresent()) {
			UserEntity entity = opEntity.get();
			if (entity.getPassword().equals(AppUtil.md5(password))) {
				return converter.toModel(entity);
			}
		}
		
		return null;
	}
}
