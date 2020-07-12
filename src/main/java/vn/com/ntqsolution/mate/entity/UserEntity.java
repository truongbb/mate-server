package vn.com.ntqsolution.mate.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import vn.com.ntqsolution.mate.constant.DatabaseName;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = DatabaseName.UserDb.USER_COLLECTION)
public class UserEntity {

  @Id
  String _id;

  String email;

  String password;

  @Field("is_activated")
  Boolean isActivated = true;

  // https://docs.spring.io/spring-data/mongodb/docs/1.3.3.RELEASE/reference/html/mapping-chapter.html
  // https://stackoverflow.com/questions/41534708/how-can-i-join-two-collections-spring-data-mongdb-as-manytomany-rdbms
  @DBRef(lazy = true)
  Set<AuthorityEntity> authorities = new HashSet<>();

}
