package vn.com.ntqsolution.mate.config.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * @author truongbb
 */
@Configuration
@EnableMongoRepositories(basePackages = {"vn.com.ntqsolution.mate.repository.banner"}, mongoTemplateRef = "settingMongoTemplate")
@ConfigurationProperties(prefix = "application.database.mongodb.db-list.settingdb")
public class SettingDbConnection extends AbstractMongoConfig {

  @Override
  @Bean(name = "settingMongoTemplate")
  public MongoTemplate getMongoTemplate() {
    return new MongoTemplate(mongoDbFactory());
  }

}
