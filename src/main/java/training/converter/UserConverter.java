package training.converter;

import training.entity.UserEntity;
import training.model.UserModel;

public class UserConverter implements IConverter<UserModel, UserEntity>{

	@Override
	public UserModel toModel(UserEntity entity) {
		UserModel model = new UserModel();
		model.setId(entity.getId());
		model.setUsername(entity.getUsername());
		model.setRole(entity.getRole());
		return model;
	}

	@Override
	public UserEntity toEntity(UserModel model) {
		UserEntity entity = new UserEntity();
		entity.setUsername(model.getUsername());
		entity.setPassword(model.getPassword());
		return entity;
	}

}
