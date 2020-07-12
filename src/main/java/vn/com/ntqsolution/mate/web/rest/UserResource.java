package vn.com.ntqsolution.mate.web.rest;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.ntqsolution.mate.entity.UserEntity;
import vn.com.ntqsolution.mate.service.user.UserService;
import vn.com.ntqsolution.mate.util.Validators;
import vn.com.ntqsolution.mate.web.vm.UserVm;

import java.util.List;

@Slf4j
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("${spring.data.rest.base-path}/user")
public class UserResource {

  @Autowired
  UserService userService;

  @PostMapping(value = "/search")
  public ResponseEntity<List<UserEntity>> search(@RequestBody(required = false) UserVm userVm) {
    log.debug("search api entered...");
    List<UserEntity> users = userService.search(userVm);
    return !Validators.validCollection(users) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping(value = "/get-user-info")
  public ResponseEntity<UserEntity> getUserInfo() {
    UserEntity user = userService.getUserInfo();
    return !Validators.validObject(user) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(user, HttpStatus.OK);
  }

}
