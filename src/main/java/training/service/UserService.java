package training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.entity.UserEntity;
import training.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}
	
	public UserEntity findById(Long id) {
		Optional<UserEntity> entity = userRepository.findById(id);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			return null;
		}
	}

	public UserEntity regist(UserEntity model) {
		return userRepository.save(model);
	}
	
	public UserEntity update(UserEntity model) {
		return userRepository.save(model);
	}
	
}
