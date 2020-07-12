package vn.com.ntqsolution.mate.web.vm;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public class BaseVm {

  Integer skip = 0;
  Integer take = 10;

}
