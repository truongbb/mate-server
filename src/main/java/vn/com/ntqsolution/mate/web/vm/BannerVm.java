package vn.com.ntqsolution.mate.web.vm;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerVm extends BaseVm {

  Boolean isShown;
  String url;

}
