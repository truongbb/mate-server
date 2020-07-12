package vn.com.ntqsolution.mate.repository.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.com.ntqsolution.mate.entity.UserEntity;

import java.util.Optional;

public interface UserRepositoryJpa extends MongoRepository<UserEntity, String> {

  Optional<UserEntity> findOneByEmail(String email);

}
