package training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.converter.UserConverter;
import training.entity.UserEntity;
import training.model.UserModel;
import training.repository.UserRepository;
import training.utils.AppUtil;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter converter;

	public List<UserModel> findAll() {
		List<UserModel> listModel = new ArrayList<UserModel>();
		List<UserEntity> listEntity = userRepository.findAll();
		for (UserEntity userEntity : listEntity) {
			listModel.add(converter.toModel(userEntity));
		}
		return listModel;
	}
	
	public UserModel findById(Long id) {
		Optional<UserEntity> opEntity = userRepository.findById(id);
		if (opEntity.isPresent()) {
			return converter.toModel(opEntity.get());
		} else {
			return null;
		}
	}
	
	public UserModel findByUsername(String username) {
		Optional<UserEntity> opEntity = userRepository.findByUsername(username);
		if (opEntity.isPresent()) {
			return converter.toModel(opEntity.get());
		} else {
			return null;
		}
	}

	public UserModel regist(UserModel model) {
		model.setPassword(AppUtil.md5(model.getPassword()));
		UserEntity entity = converter.toEntity(model);
		entity.setRole(UserEntity.Role.member);
		entity = userRepository.save(entity);
		return converter.toModel(entity);
	}
	
	public UserModel update(UserModel model) {
		if (model.getPassword() != null && !model.getPassword().isEmpty()) {
			model.setPassword(AppUtil.md5(model.getPassword()));
		}
		Optional<UserEntity> opEntity = userRepository.findById(model.getId());
		if (opEntity.isPresent()) {
			UserEntity entity = opEntity.get();
			converter.toEntity(model);
			entity = userRepository.save(entity);
			return converter.toModel(entity);
		} else {
			return null;
		}
	}
	
}
