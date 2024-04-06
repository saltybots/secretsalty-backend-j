package com.secretsalty.secretsalty.repository.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Participant {

  private UUID groupUuid;
  private UUID userUuid;
  private LocalDateTime created;
  private LocalDateTime lastModified;
  private UUID excludedUser;
  private UUID avoidUser;
  private String interests;
  private UUID bengerlUuid;
}
