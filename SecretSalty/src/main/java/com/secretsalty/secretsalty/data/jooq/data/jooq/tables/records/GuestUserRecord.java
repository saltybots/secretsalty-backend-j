/*
 * This file is generated by jOOQ.
 */
package data.jooq.tables.records;


import data.jooq.tables.GuestUser;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class GuestUserRecord extends TableRecordImpl<GuestUserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.guest_user.uuid</code>.
     */
    public GuestUserRecord setUuid(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.guest_user.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.guest_user.created</code>.
     */
    public GuestUserRecord setCreated(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.guest_user.created</code>.
     */
    public LocalDateTime getCreated() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.guest_user.last_modified</code>.
     */
    public GuestUserRecord setLastModified(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.guest_user.last_modified</code>.
     */
    public LocalDateTime getLastModified() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.guest_user.email</code>.
     */
    public GuestUserRecord setEmail(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.guest_user.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.guest_user.display_name</code>.
     */
    public GuestUserRecord setDisplayName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.guest_user.display_name</code>.
     */
    public String getDisplayName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.guest_user.group_id</code>.
     */
    public GuestUserRecord setGroupId(UUID value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.guest_user.group_id</code>.
     */
    public UUID getGroupId() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.guest_user.personal_invite</code>.
     */
    public GuestUserRecord setPersonalInvite(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.guest_user.personal_invite</code>.
     */
    public String getPersonalInvite() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GuestUserRecord
     */
    public GuestUserRecord() {
        super(GuestUser.GUEST_USER);
    }

    /**
     * Create a detached, initialised GuestUserRecord
     */
    public GuestUserRecord(UUID uuid, LocalDateTime created, LocalDateTime lastModified, String email, String displayName, UUID groupId, String personalInvite) {
        super(GuestUser.GUEST_USER);

        setUuid(uuid);
        setCreated(created);
        setLastModified(lastModified);
        setEmail(email);
        setDisplayName(displayName);
        setGroupId(groupId);
        setPersonalInvite(personalInvite);
        resetChangedOnNotNull();
    }
}
