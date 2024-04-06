package com.secretsalty.secretsalty.repository;

import static com.secretsalty.secretsalty.repository.RepositoryUtils.NOW;

import com.secretsalty.secretsalty.repository.model.User;
import data.jooq.tables.AppUser;
import data.jooq.tables.records.AppUserRecord;
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
public class UserRepository {

  private final DSLContext dslContext;

  @Autowired
  public UserRepository(DSLContext dslContext) {
    this.dslContext = dslContext;
  }

  @Transactional
  public User create(User newUser) {
    newUser.setCreated(NOW);
    newUser.setLastModified(NOW);

    return this.dslContext
        .insertInto(AppUser.APP_USER)
        .set(this.toRecord(newUser))
        .returning()
        .fetchOneInto(User.class);
  }

  @Transactional
  public void delete(UUID uuid) {
    this.dslContext.deleteFrom(AppUser.APP_USER).where(AppUser.APP_USER.UUID.equal(uuid)).execute();
  }

  @Transactional
  public List<User> readAll() {
    return this.dslContext.selectFrom(AppUser.APP_USER).fetchInto(User.class);
  }

  @Transactional
  public User readById(UUID uuid) {
    return this.dslContext
        .selectFrom(AppUser.APP_USER)
        .where(AppUser.APP_USER.UUID.equal(uuid))
        .fetchOneInto(User.class);
  }

  @Transactional
  public User findByFirebaseUID(String firebaseUID) {
    return this.dslContext
        .selectFrom(AppUser.APP_USER)
        .where(AppUser.APP_USER.FIREBASE_UID.equal(firebaseUID))
        .fetchOneInto(User.class);
  }

  @Transactional
  public User update(User newUser) {
    return this.dslContext
        .update(AppUser.APP_USER)
        .set(AppUser.APP_USER.DISPLAY_NAME, newUser.getDisplayName())
        .set(AppUser.APP_USER.LAST_MODIFIED, LocalDateTime.now())
        .set(AppUser.APP_USER.ICON, newUser.getIcon())
        .set(AppUser.APP_USER.INTERESTS, newUser.getInterests())
        .where(AppUser.APP_USER.UUID.equal(newUser.getUuid()))
        .returning()
        .fetchOneInto(User.class);
  }

  private AppUserRecord toRecord(User user) {
    AppUserRecord userRec = new AppUserRecord();

    userRec.setCreated(user.getCreated());
    userRec.setLastModified(user.getLastModified());
    userRec.setEmail(user.getEmail());
    userRec.setDisplayName(user.getDisplayName());
    userRec.setIcon(user.getIcon());
    userRec.setInterests(user.getInterests());
    userRec.setIsGuest(user.getIsGuest());
    userRec.setGroupUuid(user.getGroupUuid());
    userRec.setPersonalInvite(user.getPersonalInvite());
    userRec.setFirebaseUid(user.getFirebaseUid());

    return userRec;
  }
}
