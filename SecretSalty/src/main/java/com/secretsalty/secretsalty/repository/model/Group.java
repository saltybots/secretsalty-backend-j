package com.secretsalty.secretsalty.repository.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Group {

  private UUID uuid;
  private String name;
  private LocalDateTime created;
  private LocalDateTime lastModified;
  private String invite;
  private Long status;
  private UUID adminUuid;
  private long budget;
  private String description;
  private LocalDate selectionDate;
  private boolean reminder;
  private Long unlikelyCount;
}
