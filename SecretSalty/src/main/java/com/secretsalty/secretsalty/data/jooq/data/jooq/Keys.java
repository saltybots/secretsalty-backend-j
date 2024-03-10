/*
 * This file is generated by jOOQ.
 */
package data.jooq;


import data.jooq.tables.Group;
import data.jooq.tables.GuestUser;
import data.jooq.tables.Participant;
import data.jooq.tables.User;
import data.jooq.tables.records.GroupRecord;
import data.jooq.tables.records.GuestUserRecord;
import data.jooq.tables.records.ParticipantRecord;
import data.jooq.tables.records.UserRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<GroupRecord> GROUP_PKEY = Internal.createUniqueKey(Group.GROUP, DSL.name("group_pkey"), new TableField[] { Group.GROUP.UUID }, true);
    public static final UniqueKey<UserRecord> USER_EMAIL_KEY = Internal.createUniqueKey(User.USER, DSL.name("user_email_key"), new TableField[] { User.USER.EMAIL }, true);
    public static final UniqueKey<UserRecord> USER_PKEY = Internal.createUniqueKey(User.USER, DSL.name("user_pkey"), new TableField[] { User.USER.UUID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<GroupRecord, UserRecord> GROUP__GROUP_ADMIN_ID_FKEY = Internal.createForeignKey(Group.GROUP, DSL.name("group_admin_id_fkey"), new TableField[] { Group.GROUP.ADMIN_ID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<GuestUserRecord, GroupRecord> GUEST_USER__GUEST_USER_GROUP_ID_FKEY = Internal.createForeignKey(GuestUser.GUEST_USER, DSL.name("guest_user_group_id_fkey"), new TableField[] { GuestUser.GUEST_USER.GROUP_ID }, Keys.GROUP_PKEY, new TableField[] { Group.GROUP.UUID }, true);
    public static final ForeignKey<ParticipantRecord, UserRecord> PARTICIPANT__PARTICIPANT_AVOID_FKEY = Internal.createForeignKey(Participant.PARTICIPANT, DSL.name("participant_avoid_fkey"), new TableField[] { Participant.PARTICIPANT.AVOID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ParticipantRecord, UserRecord> PARTICIPANT__PARTICIPANT_BENGERL_ID_FKEY = Internal.createForeignKey(Participant.PARTICIPANT, DSL.name("participant_bengerl_id_fkey"), new TableField[] { Participant.PARTICIPANT.BENGERL_ID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ParticipantRecord, UserRecord> PARTICIPANT__PARTICIPANT_EXCLUDED_FKEY = Internal.createForeignKey(Participant.PARTICIPANT, DSL.name("participant_excluded_fkey"), new TableField[] { Participant.PARTICIPANT.EXCLUDED }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
    public static final ForeignKey<ParticipantRecord, GroupRecord> PARTICIPANT__PARTICIPANT_GROUP_ID_FKEY = Internal.createForeignKey(Participant.PARTICIPANT, DSL.name("participant_group_id_fkey"), new TableField[] { Participant.PARTICIPANT.GROUP_ID }, Keys.GROUP_PKEY, new TableField[] { Group.GROUP.UUID }, true);
    public static final ForeignKey<ParticipantRecord, UserRecord> PARTICIPANT__PARTICIPANT_USER_ID_FKEY = Internal.createForeignKey(Participant.PARTICIPANT, DSL.name("participant_user_id_fkey"), new TableField[] { Participant.PARTICIPANT.USER_ID }, Keys.USER_PKEY, new TableField[] { User.USER.UUID }, true);
}
