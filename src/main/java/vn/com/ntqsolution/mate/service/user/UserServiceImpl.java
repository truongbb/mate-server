package vn.com.ntqsolution.mate.service.user;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.ntqsolution.mate.entity.UserEntity;
import vn.com.ntqsolution.mate.repository.user.UserRepository;
import vn.com.ntqsolution.mate.repository.user.UserRepositoryJpa;
import vn.com.ntqsolution.mate.web.vm.UserVm;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserRepositoryJpa userRepositoryJpa;

  @Override
  public List<UserEntity> search(UserVm userVm) {
    log.debug("search service entered...");
    return userRepository.search(userVm);
  }

  @Override
  public UserEntity getUserInfo() {

    UserEntity userEntity;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserDetails principal = (UserDetails) authentication.getPrincipal();
    String email = principal.getUsername();
    Optional<UserEntity> userOptional = userRepositoryJpa.findOneByEmail(email);
    if (userOptional.isPresent()) {
      userEntity = userOptional.get();
      userEntity.setPassword(null);
    } else {
      throw new UsernameNotFoundException("Email " + email + " not found");
    }
    return userEntity;
  }

}
