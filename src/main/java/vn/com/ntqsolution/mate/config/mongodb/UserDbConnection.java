package vn.com.ntqsolution.mate.config.mongodb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"vn.com.ntqsolution.mate.repository.user"}, mongoTemplateRef = "userMongoTemplate")
@ConfigurationProperties(prefix = "application.database.mongodb.db-list.userdb")
public class UserDbConnection extends AbstractMongoConfig {

  /**
   * Implementation of the MongoTemplate factory method
   *
   * @Bean gives a name (userMongoTemplate) to the created MongoTemplate instance
   * @Primary declares that if MongoTemplate is autowired without providing a specific name, this is the instance which will be mapped by default
   */
  @Primary
  @Override
  @Bean(name = "userMongoTemplate")
  public MongoTemplate getMongoTemplate() {
    return new MongoTemplate(mongoDbFactory());
  }

}
