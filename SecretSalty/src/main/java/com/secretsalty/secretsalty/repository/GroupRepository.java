package com.secretsalty.secretsalty.repository;

import com.secretsalty.secretsalty.repository.model.Group;
import data.jooq.tables.AppGroup;
import data.jooq.tables.records.AppGroupRecord;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
public class GroupRepository {

  private final DSLContext dslContext;

  @Autowired
  public GroupRepository(DSLContext dslContext) {
    this.dslContext = dslContext;
  }

  @Transactional
  public Group create(Group newGroup) {
    LocalDateTime now = LocalDateTime.now();
    newGroup.setCreated(now);
    newGroup.setLastModified(now);

    // TODO also set participant relation for admin in db on group creation (DB trigger)

    return this.dslContext
        .insertInto(AppGroup.APP_GROUP)
        .set(this.toRecord(newGroup))
        .returning()
        .fetchOneInto(Group.class);
  }

  @Transactional
  public List<Group> readAll() {
    return this.dslContext.selectFrom(AppGroup.APP_GROUP).fetchInto(Group.class);
  }

  @Transactional
  public Group readByUUID(UUID uuid) {
    return this.dslContext
        .selectFrom(AppGroup.APP_GROUP)
        .where(AppGroup.APP_GROUP.UUID.equal(uuid))
        .fetchOneInto(Group.class);
  }

  @Transactional
  public Group update(Group newGroup) {
    newGroup.setLastModified(LocalDateTime.now());
    return this.dslContext
        .update(AppGroup.APP_GROUP)
        .set(this.toRecord(newGroup))
        .where(AppGroup.APP_GROUP.UUID.equal(newGroup.getUuid()))
        .returning()
        .fetchOneInto(Group.class);
  }

  @Transactional
  public void delete(UUID uuid) {
    this.dslContext
        .deleteFrom(AppGroup.APP_GROUP)
        .where(AppGroup.APP_GROUP.UUID.equal(uuid))
        .execute();
  }

  private AppGroupRecord toRecord(Group group) {
    AppGroupRecord groupRecord = new AppGroupRecord();

    groupRecord.setCreated(group.getCreated());
    groupRecord.setLastModified(group.getLastModified());
    groupRecord.setName(group.getName());
    groupRecord.setInvite(group.getInvite());
    groupRecord.setStatus(group.getStatus());
    groupRecord.setAdminUuid(group.getAdminUuid());
    groupRecord.setBudget(group.getBudget());
    groupRecord.setDescription(group.getDescription());
    groupRecord.setSelectionDate(group.getSelectionDate());
    groupRecord.setReminder(group.isReminder());
    groupRecord.setUnlikelyCount(group.getUnlikelyCount());

    return groupRecord;
  }
}
