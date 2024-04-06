package com.secretsalty.secretsalty.repository.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

  private UUID uuid;
  private LocalDateTime created;
  private LocalDateTime lastModified;
  private String email;
  private String displayName;
  private String icon;
  private String interests;
  private Boolean isGuest;
  private UUID groupUuid;
  private String personalInvite;
  private String firebaseUid;
}
