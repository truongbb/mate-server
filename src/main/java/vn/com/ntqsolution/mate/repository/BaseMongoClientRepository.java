package vn.com.ntqsolution.mate.repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * https://docs.spring.io/spring-data/mongodb/docs/2.0.5.RELEASE/reference/pdf/spring-data-mongodb-reference.pdf
 *
 * https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.core
 *
 */

@Getter
@Repository
public abstract class BaseMongoClientRepository {

  @Autowired
  MongoClient mongoClient;

  protected abstract DB getDatabase();

  protected abstract String getCollectionName();

  protected DBCollection getCollection() {
    return getDatabase().getCollection(getCollectionName());
  }

  protected void put(DBObject obj, String field, Object value) {
    if (value != null) {
      obj.put(field, value);
    }
  }

}
