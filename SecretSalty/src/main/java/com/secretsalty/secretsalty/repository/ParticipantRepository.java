package com.secretsalty.secretsalty.repository;

import com.secretsalty.secretsalty.repository.model.Participant;
import data.jooq.tables.AppParticipant;
import data.jooq.tables.records.AppParticipantRecord;
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
public class ParticipantRepository {

  private final DSLContext dslContext;

  @Autowired
  public ParticipantRepository(DSLContext dslContext) {
    this.dslContext = dslContext;
  }

  @Transactional
  public Participant create(Participant newParticipant) {
    LocalDateTime now = LocalDateTime.now();
    newParticipant.setCreated(now);
    newParticipant.setLastModified(now);

    return this.dslContext
        .insertInto(AppParticipant.APP_PARTICIPANT)
        .set(this.toRecord(newParticipant))
        .returning()
        .fetchOneInto(Participant.class);
  }

  @Transactional
  public List<Participant> readAllByUser(UUID userUuid) {
    return this.dslContext
        .selectFrom(AppParticipant.APP_PARTICIPANT)
        .where(AppParticipant.APP_PARTICIPANT.USER_UUID.equal(userUuid))
        .fetchInto(Participant.class);
  }

  @Transactional
  public List<Participant> readAllForGroup(UUID groupUuid) {
    return this.dslContext
        .selectFrom(AppParticipant.APP_PARTICIPANT)
        .where(AppParticipant.APP_PARTICIPANT.GROUP_UUID.equal(groupUuid))
        .fetchInto(Participant.class);
  }

  @Transactional
  public Participant update(Participant newParticipant) {
    newParticipant.setLastModified(LocalDateTime.now());
    return this.dslContext
        .update(AppParticipant.APP_PARTICIPANT)
        .set(this.toRecord(newParticipant))
        .where(AppParticipant.APP_PARTICIPANT.USER_UUID.equal(newParticipant.getUserUuid()))
        .and(AppParticipant.APP_PARTICIPANT.GROUP_UUID.equal(newParticipant.getGroupUuid()))
        .returning()
        .fetchOneInto(Participant.class);
  }

  @Transactional
  public void delete(UUID userUuid, UUID groupUuid) {
    this.dslContext
        .deleteFrom(AppParticipant.APP_PARTICIPANT)
        .where(AppParticipant.APP_PARTICIPANT.USER_UUID.equal(userUuid))
        .and(AppParticipant.APP_PARTICIPANT.GROUP_UUID.equal(groupUuid))
        .execute();
  }

  private AppParticipantRecord toRecord(Participant participant) {
    AppParticipantRecord participantRecord = new AppParticipantRecord();

    participantRecord.setCreated(participant.getCreated());
    participantRecord.setLastModified(participant.getLastModified());
    participantRecord.setUserUuid(participant.getUserUuid());
    participantRecord.setGroupUuid(participant.getGroupUuid());
    participantRecord.setExcluded(participant.getExcludedUser());
    participantRecord.setAvoid(participant.getAvoidUser());
    participantRecord.setInterests(participant.getInterests());
    // TODO: readd sometime soon
    // participantRecord.setBengerlUuid(participant.getBengerlUuid());

    return participantRecord;
  }
}
