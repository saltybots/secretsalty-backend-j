/*
 * This file is generated by jOOQ.
 */
package data.jooq.tables;

import data.jooq.Keys;
import data.jooq.Public;
import data.jooq.tables.records.AppGroupRecord;
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

/** This class is generated by jOOQ. */
@SuppressWarnings({"all", "unchecked", "rawtypes", "this-escape"})
public class AppGroup extends TableImpl<AppGroupRecord> {

  private static final long serialVersionUID = 1L;

  /** The reference instance of <code>public.app_group</code> */
  public static final AppGroup APP_GROUP = new AppGroup();

  /** The class holding records for this type */
  @Override
  public Class<AppGroupRecord> getRecordType() {
    return AppGroupRecord.class;
  }

  /** The column <code>public.app_group.uuid</code>. */
  public final TableField<AppGroupRecord, java.util.UUID> UUID =
      createField(
          DSL.name("uuid"),
          SQLDataType.UUID
              .nullable(false)
              .defaultValue(DSL.field(DSL.raw("gen_random_uuid()"), SQLDataType.UUID)),
          this,
          "");

  /** The column <code>public.app_group.name</code>. */
  public final TableField<AppGroupRecord, String> NAME =
      createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

  /** The column <code>public.app_group.created</code>. */
  public final TableField<AppGroupRecord, LocalDateTime> CREATED =
      createField(
          DSL.name("created"),
          SQLDataType.LOCALDATETIME(6)
              .nullable(false)
              .defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)),
          this,
          "");

  /** The column <code>public.app_group.last_modified</code>. */
  public final TableField<AppGroupRecord, LocalDateTime> LAST_MODIFIED =
      createField(
          DSL.name("last_modified"),
          SQLDataType.LOCALDATETIME(6)
              .nullable(false)
              .defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)),
          this,
          "");

  /** The column <code>public.app_group.invite</code>. */
  public final TableField<AppGroupRecord, String> INVITE =
      createField(DSL.name("invite"), SQLDataType.VARCHAR.nullable(false), this, "");

  /** The column <code>public.app_group.status</code>. */
  public final TableField<AppGroupRecord, Long> STATUS =
      createField(DSL.name("status"), SQLDataType.BIGINT.nullable(false), this, "");

  /** The column <code>public.app_group.admin_uuid</code>. */
  public final TableField<AppGroupRecord, java.util.UUID> ADMIN_UUID =
      createField(DSL.name("admin_uuid"), SQLDataType.UUID.nullable(false), this, "");

  /** The column <code>public.app_group.budget</code>. */
  public final TableField<AppGroupRecord, Long> BUDGET =
      createField(DSL.name("budget"), SQLDataType.BIGINT, this, "");

  /** The column <code>public.app_group.description</code>. */
  public final TableField<AppGroupRecord, String> DESCRIPTION =
      createField(DSL.name("description"), SQLDataType.VARCHAR, this, "");

  /** The column <code>public.app_group.selection_date</code>. */
  public final TableField<AppGroupRecord, LocalDate> SELECTION_DATE =
      createField(DSL.name("selection_date"), SQLDataType.LOCALDATE, this, "");

  /** The column <code>public.app_group.reminder</code>. */
  public final TableField<AppGroupRecord, Boolean> REMINDER =
      createField(DSL.name("reminder"), SQLDataType.BOOLEAN, this, "");

  /** The column <code>public.app_group.unlikely_count</code>. */
  public final TableField<AppGroupRecord, Long> UNLIKELY_COUNT =
      createField(DSL.name("unlikely_count"), SQLDataType.BIGINT, this, "");

  private AppGroup(Name alias, Table<AppGroupRecord> aliased) {
    this(alias, aliased, null);
  }

  private AppGroup(Name alias, Table<AppGroupRecord> aliased, Field<?>[] parameters) {
    super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
  }

  /** Create an aliased <code>public.app_group</code> table reference */
  public AppGroup(String alias) {
    this(DSL.name(alias), APP_GROUP);
  }

  /** Create an aliased <code>public.app_group</code> table reference */
  public AppGroup(Name alias) {
    this(alias, APP_GROUP);
  }

  /** Create a <code>public.app_group</code> table reference */
  public AppGroup() {
    this(DSL.name("app_group"), null);
  }

  public <O extends Record> AppGroup(Table<O> child, ForeignKey<O, AppGroupRecord> key) {
    super(child, key, APP_GROUP);
  }

  @Override
  public Schema getSchema() {
    return aliased() ? null : Public.PUBLIC;
  }

  @Override
  public UniqueKey<AppGroupRecord> getPrimaryKey() {
    return Keys.APP_GROUP_PKEY;
  }

  @Override
  public List<UniqueKey<AppGroupRecord>> getUniqueKeys() {
    return Arrays.asList(Keys.APP_GROUP_INVITE_KEY);
  }

  @Override
  public List<ForeignKey<AppGroupRecord, ?>> getReferences() {
    return Arrays.asList(Keys.APP_GROUP__APP_GROUP_ADMIN_UUID_FKEY);
  }

  private transient AppUser _appUser;

  /** Get the implicit join path to the <code>public.app_user</code> table. */
  public AppUser appUser() {
    if (_appUser == null) {
      _appUser = new AppUser(this, Keys.APP_GROUP__APP_GROUP_ADMIN_UUID_FKEY);
    }

    return _appUser;
  }

  @Override
  public AppGroup as(String alias) {
    return new AppGroup(DSL.name(alias), this);
  }

  @Override
  public AppGroup as(Name alias) {
    return new AppGroup(alias, this);
  }

  @Override
  public AppGroup as(Table<?> alias) {
    return new AppGroup(alias.getQualifiedName(), this);
  }

  /** Rename this table */
  @Override
  public AppGroup rename(String name) {
    return new AppGroup(DSL.name(name), null);
  }

  /** Rename this table */
  @Override
  public AppGroup rename(Name name) {
    return new AppGroup(name, null);
  }

  /** Rename this table */
  @Override
  public AppGroup rename(Table<?> name) {
    return new AppGroup(name.getQualifiedName(), null);
  }
}
