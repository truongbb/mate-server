package vn.com.ntqsolution.mate.service.user;

import vn.com.ntqsolution.mate.entity.UserEntity;
import vn.com.ntqsolution.mate.web.vm.UserVm;

import java.util.List;

public interface UserService {

  List<UserEntity> search(UserVm userVm);

  UserEntity getUserInfo();

}
