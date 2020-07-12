package vn.com.ntqsolution.mate.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import vn.com.ntqsolution.mate.constant.DatabaseName;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = DatabaseName.SettingDb.BANNER_COLLECTION)
public class BannerEntity {

  @Id
  String _id;

  @Field("update_date")
  Date updateDate;

  @Field("image_id")
  String imageId;

  @Field("is_shown")
  Boolean isShown;

  String url;

}
