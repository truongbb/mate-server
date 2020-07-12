package vn.com.ntqsolution.mate.repository.banner;

import vn.com.ntqsolution.mate.entity.BannerEntity;
import vn.com.ntqsolution.mate.web.vm.BannerVm;

import java.util.List;

public interface BannerRepository {

  List<BannerEntity> search(BannerVm bannerVm);

}
