package vn.com.ntqsolution.mate.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MongoDbConfiguration {

  //<editor-fold desc="CONFIGURATION VARIABLES">
  @Value("${application.database.mongodb.primary.host}")
  private String primaryHost;

  @Value("${application.database.mongodb.primary.port}")
  private Integer primaryPort;

  @Value("${application.database.mongodb.primary.connectionPerHost}")
  private Integer primaryConnectionPerHost;

  @Value("${application.database.mongodb.primary.user}")
  private String primaryUser;

  @Value("${application.database.mongodb.primary.password}")
  private String primaryPassword;

  @Value("${application.database.mongodb.primary.authenticationDatabase}")
  private String primaryAuthenticationDatabase;

  @Value("${application.database.mongodb.secondary.host}")
  private String secondaryHost;

  @Value("${application.database.mongodb.secondary.port}")
  private Integer secondaryPort;

  @Value("${application.database.mongodb.secondary.connectionPerHost}")
  private Integer secondaryConnectionPerHost;

  @Value("${application.database.mongodb.secondary.user}")
  private String secondaryUser;

  @Value("${application.database.mongodb.secondary.password}")
  private String secondaryPassword;

  @Value("${application.database.mongodb.secondary.authenticationDatabase}")
  private String secondaryAuthenticationDatabase;
  //</editor-fold>

  @Bean
  public MongoClient mongoClient() {
    MongoCredential primaryCredential = MongoCredential.createCredential(this.primaryUser, this.primaryAuthenticationDatabase, this.primaryPassword.toCharArray());
    MongoCredential secondaryCredential = MongoCredential.createCredential(this.secondaryUser, this.secondaryAuthenticationDatabase, this.secondaryPassword.toCharArray());

    MongoClientOptions option = new MongoClientOptions.Builder().connectionsPerHost(this.primaryConnectionPerHost).readPreference(ReadPreference.primaryPreferred()).build();

    return new MongoClient(
      Arrays.asList(new ServerAddress(this.primaryHost, this.primaryPort), new ServerAddress(this.secondaryHost, this.secondaryPort)),
      Arrays.asList(primaryCredential, secondaryCredential),
      option
    );

  }

}

