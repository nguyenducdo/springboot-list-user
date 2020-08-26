package training.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import training.entity.UserEntity;
import training.model.UserModel;
import training.repository.UserRepository;

@Component
public class UserConverter implements IConverter<UserModel, UserEntity>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserModel toModel(UserEntity entity) {
		UserModel model = new UserModel();
		model.setId(entity.getId());
		model.setUsername(entity.getUsername());
		model.setRole(entity.getRole().name());
		return model;
	}

	@Override
	public UserEntity toEntity(UserModel model) {
		UserEntity entity = new UserEntity();
		if (model.getId() != null) {
			Optional<UserEntity> opEntity = userRepository.findById(model.getId());
			if (opEntity.isPresent()) {
				entity = opEntity.get();
			}
		}
		entity.setUsername(model.getUsername());
		entity.setPassword(model.getPassword());
		return entity;
	}

}
