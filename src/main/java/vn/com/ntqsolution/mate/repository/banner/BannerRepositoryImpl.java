package vn.com.ntqsolution.mate.repository.banner;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import vn.com.ntqsolution.mate.entity.BannerEntity;
import vn.com.ntqsolution.mate.repository.BaseMongoTemplateRepository;
import vn.com.ntqsolution.mate.web.vm.BannerVm;

import java.util.List;

@Repository
public class BannerRepositoryImpl extends BaseMongoTemplateRepository implements BannerRepository {

  private static final String IS_SHOWN = "is_shown";
  private static final String UPDATE_DATE = "update_date";
  private static final String IMAGE_ID = "image_id";
  private static final String URL = "url";

  @Override
  public List<BannerEntity> search(BannerVm bannerVm) {
    Query query = new Query();
    query.addCriteria(Criteria.where(IS_SHOWN).is(true)).skip(bannerVm.getSkip()).limit(bannerVm.getTake());
    List<BannerEntity> banners = getSettingMongoTemplate().find(query, BannerEntity.class);
    return banners;
  }

}
