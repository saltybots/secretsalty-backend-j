/*
 * This file is generated by jOOQ.
 */
package data.jooq.routines;


import data.jooq.Public;

import java.util.UUID;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class UuidGenerateV5 extends AbstractRoutine<UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.uuid_generate_v5.RETURN_VALUE</code>.
     */
    public static final Parameter<UUID> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.UUID, false, false);

    /**
     * The parameter <code>public.uuid_generate_v5.namespace</code>.
     */
    public static final Parameter<UUID> NAMESPACE = Internal.createParameter("namespace", SQLDataType.UUID, false, false);

    /**
     * The parameter <code>public.uuid_generate_v5.name</code>.
     */
    public static final Parameter<String> NAME = Internal.createParameter("name", SQLDataType.CLOB, false, false);

    /**
     * Create a new routine call instance
     */
    public UuidGenerateV5() {
        super("uuid_generate_v5", Public.PUBLIC, SQLDataType.UUID);

        setReturnParameter(RETURN_VALUE);
        addInParameter(NAMESPACE);
        addInParameter(NAME);
    }

    /**
     * Set the <code>namespace</code> parameter IN value to the routine
     */
    public void setNamespace(UUID value) {
        setValue(NAMESPACE, value);
    }

    /**
     * Set the <code>namespace</code> parameter to the function to be used with
     * a {@link org.jooq.Select} statement
     */
    public UuidGenerateV5 setNamespace(Field<UUID> field) {
        setField(NAMESPACE, field);
        return this;
    }

    /**
     * Set the <code>name</code> parameter IN value to the routine
     */
    public void setName_(String value) {
        setValue(NAME, value);
    }

    /**
     * Set the <code>name</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public UuidGenerateV5 setName_(Field<String> field) {
        setField(NAME, field);
        return this;
    }
}
