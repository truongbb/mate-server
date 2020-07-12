package vn.com.ntqsolution.mate.service.banner;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.ntqsolution.mate.entity.BannerEntity;
import vn.com.ntqsolution.mate.repository.banner.BannerRepository;
import vn.com.ntqsolution.mate.web.vm.BannerVm;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BannerServiceImpl implements BannerService {

  @Autowired
  BannerRepository bannerRepository;

  @Override
  public List<BannerEntity> search(BannerVm bannerVm) {
    return bannerRepository.search(bannerVm);
  }

}
