package vn.com.ntqsolution.mate.security;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vn.com.ntqsolution.mate.entity.UserEntity;
import vn.com.ntqsolution.mate.repository.user.UserRepositoryJpa;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  UserRepositoryJpa userRepositoryJpa;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    log.trace("Service authenticate: {}", email);
    if (new EmailValidator().isValid(email, null)) {
      return userRepositoryJpa.findOneByEmail(email)
        .map(user -> createSpringSecurityUser(email, user))
        .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found in the database"));
    } else return null;
  }

  private org.springframework.security.core.userdetails.User createSpringSecurityUser(String email, UserEntity user) {
    if (!user.getIsActivated()) {
      throw new UserNotActivatedException("User " + email + " was not activated");
    }
    List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
  }

}
