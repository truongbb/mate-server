package vn.com.ntqsolution.mate.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.com.ntqsolution.mate.constant.DatabaseName;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = DatabaseName.UserDb.AUTHORITY_COLLECTION)
public class AuthorityEntity {

  @Id
  String _id;

  String name;

}
