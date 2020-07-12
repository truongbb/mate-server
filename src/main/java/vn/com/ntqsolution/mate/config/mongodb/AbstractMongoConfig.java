package vn.com.ntqsolution.mate.config.mongodb;

import com.mongodb.MongoClient;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author truongbb
 * @see <a href="https://walkingtechie.blogspot.com/2017/07/using-multiple-datasources-of-mongodb.html">this reference</a>
 * @since 2020-02-15
 *
 * <p>
 * Abstract configuration class for multi-database MongoTemplate
 * <br/>
 * </p>
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbstractMongoConfig {

  @Autowired
  MongoClient mongoClient;

  //Mongo DB Properties
  String host;
  int port;
  String database;

  /*
   * Method that creates MongoDbFactory
   * Common to both of the MongoDb connections
   */
  public MongoDbFactory mongoDbFactory() {
    return new SimpleMongoDbFactory(this.mongoClient, database);
  }


  /*
   * Factory method to create the MongoTemplate
   */
  abstract public MongoTemplate getMongoTemplate();

}
