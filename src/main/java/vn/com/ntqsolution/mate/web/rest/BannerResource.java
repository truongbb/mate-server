package vn.com.ntqsolution.mate.web.rest;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.ntqsolution.mate.entity.BannerEntity;
import vn.com.ntqsolution.mate.service.banner.BannerService;
import vn.com.ntqsolution.mate.util.Validators;
import vn.com.ntqsolution.mate.web.vm.BannerVm;

import java.util.List;

@Slf4j
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("${spring.data.rest.base-path}/banner")
public class BannerResource {

  @Autowired
  BannerService bannerService;

  @PostMapping(value = "/search")
  public ResponseEntity<List<BannerEntity>> search(@RequestBody(required = false) BannerVm bannerVm) {
    log.debug("search api entered...");
    List<BannerEntity> users = bannerService.search(bannerVm);
    return !Validators.validCollection(users) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(users, HttpStatus.OK);
  }

}
