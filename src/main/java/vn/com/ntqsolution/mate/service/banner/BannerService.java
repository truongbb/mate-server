package vn.com.ntqsolution.mate.service.banner;

import vn.com.ntqsolution.mate.entity.BannerEntity;
import vn.com.ntqsolution.mate.web.vm.BannerVm;

import java.util.List;

public interface BannerService {

  List<BannerEntity> search(BannerVm bannerVm);

}
