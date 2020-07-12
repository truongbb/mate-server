package vn.com.ntqsolution.mate.web.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.ntqsolution.mate.security.jwt.JWTFilter;
import vn.com.ntqsolution.mate.security.jwt.TokenProvider;
import vn.com.ntqsolution.mate.web.vm.UserVm;

import javax.validation.Valid;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class AuthenticationResource {

  @Autowired
  private AuthenticationManagerBuilder authenticationManagerBuilder;

  @Autowired
  private TokenProvider tokenProvider;

  @PostMapping("/authenticate")
  public ResponseEntity<Object> authorize(@Valid @RequestBody UserVm userVm) {
    log.trace("REST request to authenticate user: {}", userVm);
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userVm.getEmail(), userVm.getPassword());
    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = tokenProvider.createToken(authentication, userVm.getRememberMe());
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, String.format("Bearer %s", jwt));
    return new ResponseEntity<>(Collections.singletonMap("token", jwt), httpHeaders, HttpStatus.OK);
  }

}
