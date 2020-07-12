package vn.com.ntqsolution.mate.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author truongbb
 * @see vn.com.ntqsolution.mate.repository.banner.BannerRepositoryImpl to know how to use MoongoTemplate to execute Mongo queries.
 * @see <a href="https://www.baeldung.com/mongodb-bson">this reference</a> to get more techs about MongoTemplate & BSON.
 * <p>
 * Base repository for using MongoTemplate
 * <br/>
 * This class lists all mongoTemplate for each database configured in package vn.com.ntqsolution.mate.config.mongodb.
 * When you want to configurate a new mongoTemplate, you should do following steps:
 * - Add configuration in application.yml at application.database.mongodb.db-list.
 * - Create class implementing AbstractMongoConfig (in package vn.com.ntqsolution.mate.config.mongodb).
 * - Declare an injected bean here with @Qualifier annotation to point out which bean (which mongoTemplate for which database) is used.
 * </p>
 */

@Getter
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseMongoTemplateRepository {

  @Autowired
  @Qualifier("userMongoTemplate")
  MongoTemplate mongoTemplate;

  @Autowired
  @Qualifier("settingMongoTemplate")
  MongoTemplate settingMongoTemplate;

}
