package training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import training.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
