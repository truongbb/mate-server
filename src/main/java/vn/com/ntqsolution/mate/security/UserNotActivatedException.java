package vn.com.ntqsolution.mate.security;

import org.springframework.security.core.AuthenticationException;

public class UserNotActivatedException extends AuthenticationException {

  public UserNotActivatedException(String msg) {
    super(msg);
  }
    
}
