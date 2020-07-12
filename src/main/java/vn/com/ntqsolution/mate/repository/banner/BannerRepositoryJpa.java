package vn.com.ntqsolution.mate.repository.banner;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.com.ntqsolution.mate.entity.BannerEntity;

public interface BannerRepositoryJpa extends MongoRepository<BannerEntity, String> {
}
