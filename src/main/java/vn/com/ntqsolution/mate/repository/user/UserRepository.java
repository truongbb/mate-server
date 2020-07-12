package vn.com.ntqsolution.mate.repository.user;

import vn.com.ntqsolution.mate.entity.UserEntity;
import vn.com.ntqsolution.mate.web.vm.UserVm;

import java.util.List;

public interface UserRepository {

  List<UserEntity> search(UserVm userVm);

}
