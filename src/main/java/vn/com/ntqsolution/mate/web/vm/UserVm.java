package vn.com.ntqsolution.mate.web.vm;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserVm extends BaseVm {

  String email;
  String password;
  Boolean rememberMe;

}
