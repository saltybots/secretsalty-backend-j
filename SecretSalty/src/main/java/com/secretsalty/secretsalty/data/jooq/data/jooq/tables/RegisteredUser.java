/*
 * This file is generated by jOOQ.
 */
package data.jooq.tables;


import data.jooq.Public;
import data.jooq.tables.records.RegisteredUserRecord;

import java.time.LocalDateTime;

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
public class RegisteredUser extends TableImpl<RegisteredUserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.registered_user</code>
     */
    public static final RegisteredUser REGISTERED_USER = new RegisteredUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RegisteredUserRecord> getRecordType() {
        return RegisteredUserRecord.class;
    }

    /**
     * The column <code>public.registered_user.uuid</code>.
     */
    public final TableField<RegisteredUserRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("gen_random_uuid()"), SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.registered_user.created</code>.
     */
    public final TableField<RegisteredUserRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.registered_user.last_modified</code>.
     */
    public final TableField<RegisteredUserRecord, LocalDateTime> LAST_MODIFIED = createField(DSL.name("last_modified"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.registered_user.email</code>.
     */
    public final TableField<RegisteredUserRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.registered_user.display_name</code>.
     */
    public final TableField<RegisteredUserRecord, String> DISPLAY_NAME = createField(DSL.name("display_name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.registered_user.icon</code>.
     */
    public final TableField<RegisteredUserRecord, String> ICON = createField(DSL.name("icon"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.registered_user.interests</code>.
     */
    public final TableField<RegisteredUserRecord, String> INTERESTS = createField(DSL.name("interests"), SQLDataType.VARCHAR, this, "");

    private RegisteredUser(Name alias, Table<RegisteredUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private RegisteredUser(Name alias, Table<RegisteredUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.registered_user</code> table reference
     */
    public RegisteredUser(String alias) {
        this(DSL.name(alias), REGISTERED_USER);
    }

    /**
     * Create an aliased <code>public.registered_user</code> table reference
     */
    public RegisteredUser(Name alias) {
        this(alias, REGISTERED_USER);
    }

    /**
     * Create a <code>public.registered_user</code> table reference
     */
    public RegisteredUser() {
        this(DSL.name("registered_user"), null);
    }

    public <O extends Record> RegisteredUser(Table<O> child, ForeignKey<O, RegisteredUserRecord> key) {
        super(child, key, REGISTERED_USER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public RegisteredUser as(String alias) {
        return new RegisteredUser(DSL.name(alias), this);
    }

    @Override
    public RegisteredUser as(Name alias) {
        return new RegisteredUser(alias, this);
    }

    @Override
    public RegisteredUser as(Table<?> alias) {
        return new RegisteredUser(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public RegisteredUser rename(String name) {
        return new RegisteredUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public RegisteredUser rename(Name name) {
        return new RegisteredUser(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public RegisteredUser rename(Table<?> name) {
        return new RegisteredUser(name.getQualifiedName(), null);
    }
}
