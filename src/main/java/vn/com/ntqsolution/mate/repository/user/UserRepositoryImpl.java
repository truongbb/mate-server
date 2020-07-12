package vn.com.ntqsolution.mate.repository.user;

import com.mongodb.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import vn.com.ntqsolution.mate.constant.DatabaseName;
import vn.com.ntqsolution.mate.constant.DatabaseOperation;
import vn.com.ntqsolution.mate.entity.UserEntity;
import vn.com.ntqsolution.mate.repository.BaseMongoClientRepository;
import vn.com.ntqsolution.mate.util.StringUtil;
import vn.com.ntqsolution.mate.util.Validators;
import vn.com.ntqsolution.mate.web.vm.UserVm;

import java.util.*;

@Slf4j
@Repository
public class UserRepositoryImpl extends BaseMongoClientRepository implements UserRepository {

  private static final String EMAIL = "email";

  @Override
  protected DB getDatabase() {
    return getMongoClient().getDB(DatabaseName.UserDb.USER_DB_NAME);
  }

  @Override
  protected String getCollectionName() {
    return DatabaseName.UserDb.USER_COLLECTION;
  }

  @Override
  public List<UserEntity> search(UserVm userVm) {
    List<UserEntity> users = new ArrayList<>();
    int skip = 1, take = 10;

    BasicDBObject findQuery = new BasicDBObject();
    if (Validators.validObject(userVm) && !StringUtil.isNotNullAndEmptyString(userVm.getEmail())) {
      findQuery.put(EMAIL, userVm.getEmail());
      skip = userVm.getSkip();
      take = userVm.getTake();
    }

    BasicDBObject sortObj = new BasicDBObject(DatabaseOperation.ID, DatabaseOperation.DESCENDING_ORDER);

    DBCursor cursor = getCollection().find().sort(sortObj).skip(skip).limit(take);
    while (cursor.hasNext()) {
      DBObject obj = cursor.next();
      String id = obj.get(DatabaseOperation.ID).toString();
      Object emailObj = obj.get(EMAIL);
      String email = null;
      if (Validators.validObject(emailObj)) {
        email = emailObj.toString();
      }
      users.add(new UserEntity(id, email, null, true, new HashSet<>()));
    }

    return users;
  }

}
