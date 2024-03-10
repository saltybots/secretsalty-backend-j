/*
 * This file is generated by jOOQ.
 */
package data.jooq.tables;


import data.jooq.Keys;
import data.jooq.Public;
import data.jooq.tables.records.GuestUserRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class GuestUser extends TableImpl<GuestUserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.guest_user</code>
     */
    public static final GuestUser GUEST_USER = new GuestUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GuestUserRecord> getRecordType() {
        return GuestUserRecord.class;
    }

    /**
     * The column <code>public.guest_user.uuid</code>.
     */
    public final TableField<GuestUserRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("gen_random_uuid()"), SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.guest_user.created</code>.
     */
    public final TableField<GuestUserRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.guest_user.last_modified</code>.
     */
    public final TableField<GuestUserRecord, LocalDateTime> LAST_MODIFIED = createField(DSL.name("last_modified"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.guest_user.email</code>.
     */
    public final TableField<GuestUserRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.guest_user.display_name</code>.
     */
    public final TableField<GuestUserRecord, String> DISPLAY_NAME = createField(DSL.name("display_name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.guest_user.group_id</code>.
     */
    public final TableField<GuestUserRecord, java.util.UUID> GROUP_ID = createField(DSL.name("group_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.guest_user.personal_invite</code>.
     */
    public final TableField<GuestUserRecord, String> PERSONAL_INVITE = createField(DSL.name("personal_invite"), SQLDataType.VARCHAR.nullable(false), this, "");

    private GuestUser(Name alias, Table<GuestUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private GuestUser(Name alias, Table<GuestUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.guest_user</code> table reference
     */
    public GuestUser(String alias) {
        this(DSL.name(alias), GUEST_USER);
    }

    /**
     * Create an aliased <code>public.guest_user</code> table reference
     */
    public GuestUser(Name alias) {
        this(alias, GUEST_USER);
    }

    /**
     * Create a <code>public.guest_user</code> table reference
     */
    public GuestUser() {
        this(DSL.name("guest_user"), null);
    }

    public <O extends Record> GuestUser(Table<O> child, ForeignKey<O, GuestUserRecord> key) {
        super(child, key, GUEST_USER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<ForeignKey<GuestUserRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GUEST_USER__GUEST_USER_GROUP_ID_FKEY);
    }

    private transient Group _group;

    /**
     * Get the implicit join path to the <code>public.group</code> table.
     */
    public Group group() {
        if (_group == null)
            _group = new Group(this, Keys.GUEST_USER__GUEST_USER_GROUP_ID_FKEY);

        return _group;
    }

    @Override
    public GuestUser as(String alias) {
        return new GuestUser(DSL.name(alias), this);
    }

    @Override
    public GuestUser as(Name alias) {
        return new GuestUser(alias, this);
    }

    @Override
    public GuestUser as(Table<?> alias) {
        return new GuestUser(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public GuestUser rename(String name) {
        return new GuestUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuestUser rename(Name name) {
        return new GuestUser(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public GuestUser rename(Table<?> name) {
        return new GuestUser(name.getQualifiedName(), null);
    }
}