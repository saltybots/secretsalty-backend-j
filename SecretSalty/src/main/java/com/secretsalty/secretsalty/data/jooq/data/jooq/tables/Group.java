/*
 * This file is generated by jOOQ.
 */
package data.jooq.tables;


import data.jooq.Keys;
import data.jooq.Public;
import data.jooq.tables.records.GroupRecord;

import java.time.LocalDate;
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
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Group extends TableImpl<GroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.group</code>
     */
    public static final Group GROUP = new Group();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GroupRecord> getRecordType() {
        return GroupRecord.class;
    }

    /**
     * The column <code>public.group.uuid</code>.
     */
    public final TableField<GroupRecord, java.util.UUID> UUID = createField(DSL.name("uuid"), SQLDataType.UUID.nullable(false).defaultValue(DSL.field(DSL.raw("gen_random_uuid()"), SQLDataType.UUID)), this, "");

    /**
     * The column <code>public.group.created</code>.
     */
    public final TableField<GroupRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.group.last_modified</code>.
     */
    public final TableField<GroupRecord, LocalDateTime> LAST_MODIFIED = createField(DSL.name("last_modified"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.group.invite</code>.
     */
    public final TableField<GroupRecord, String> INVITE = createField(DSL.name("invite"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.group.status</code>.
     */
    public final TableField<GroupRecord, Long> STATUS = createField(DSL.name("status"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.group.admin_id</code>.
     */
    public final TableField<GroupRecord, java.util.UUID> ADMIN_ID = createField(DSL.name("admin_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.group.budget</code>.
     */
    public final TableField<GroupRecord, Float> BUDGET = createField(DSL.name("budget"), SQLDataType.REAL, this, "");

    /**
     * The column <code>public.group.description</code>.
     */
    public final TableField<GroupRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.group.selection_date</code>.
     */
    public final TableField<GroupRecord, LocalDate> SELECTION_DATE = createField(DSL.name("selection_date"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.group.reminder</code>.
     */
    public final TableField<GroupRecord, Boolean> REMINDER = createField(DSL.name("reminder"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.group.unlikely_count</code>.
     */
    public final TableField<GroupRecord, Long> UNLIKELY_COUNT = createField(DSL.name("unlikely_count"), SQLDataType.BIGINT, this, "");

    private Group(Name alias, Table<GroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private Group(Name alias, Table<GroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.group</code> table reference
     */
    public Group(String alias) {
        this(DSL.name(alias), GROUP);
    }

    /**
     * Create an aliased <code>public.group</code> table reference
     */
    public Group(Name alias) {
        this(alias, GROUP);
    }

    /**
     * Create a <code>public.group</code> table reference
     */
    public Group() {
        this(DSL.name("group"), null);
    }

    public <O extends Record> Group(Table<O> child, ForeignKey<O, GroupRecord> key) {
        super(child, key, GROUP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<GroupRecord> getPrimaryKey() {
        return Keys.GROUP_PKEY;
    }

    @Override
    public List<ForeignKey<GroupRecord, ?>> getReferences() {
        return Arrays.asList(Keys.GROUP__GROUP_ADMIN_ID_FKEY);
    }

    private transient User _user;

    /**
     * Get the implicit join path to the <code>public.user</code> table.
     */
    public User user() {
        if (_user == null)
            _user = new User(this, Keys.GROUP__GROUP_ADMIN_ID_FKEY);

        return _user;
    }

    @Override
    public Group as(String alias) {
        return new Group(DSL.name(alias), this);
    }

    @Override
    public Group as(Name alias) {
        return new Group(alias, this);
    }

    @Override
    public Group as(Table<?> alias) {
        return new Group(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Group rename(String name) {
        return new Group(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Group rename(Name name) {
        return new Group(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Group rename(Table<?> name) {
        return new Group(name.getQualifiedName(), null);
    }
}
