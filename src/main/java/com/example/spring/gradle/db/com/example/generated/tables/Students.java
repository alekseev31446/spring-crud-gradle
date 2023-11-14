/*
 * This file is generated by jOOQ.
 */
package com.example.generated.tables;


import com.example.generated.Keys;
import com.example.generated.Public;
import com.example.generated.tables.records.StudentsRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Students extends TableImpl<StudentsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.students</code>
     */
    public static final Students STUDENTS = new Students();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentsRecord> getRecordType() {
        return StudentsRecord.class;
    }

    /**
     * The column <code>public.students.id</code>.
     */
    public final TableField<StudentsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.students.firstname</code>.
     */
    public final TableField<StudentsRecord, String> FIRSTNAME = createField(DSL.name("firstname"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.students.middlename</code>.
     */
    public final TableField<StudentsRecord, String> MIDDLENAME = createField(DSL.name("middlename"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.students.lastname</code>.
     */
    public final TableField<StudentsRecord, String> LASTNAME = createField(DSL.name("lastname"), SQLDataType.VARCHAR.nullable(false), this, "");

    private Students(Name alias, Table<StudentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Students(Name alias, Table<StudentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.students</code> table reference
     */
    public Students(String alias) {
        this(DSL.name(alias), STUDENTS);
    }

    /**
     * Create an aliased <code>public.students</code> table reference
     */
    public Students(Name alias) {
        this(alias, STUDENTS);
    }

    /**
     * Create a <code>public.students</code> table reference
     */
    public Students() {
        this(DSL.name("students"), null);
    }

    public <O extends Record> Students(Table<O> child, ForeignKey<O, StudentsRecord> key) {
        super(child, key, STUDENTS);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<StudentsRecord, Integer> getIdentity() {
        return (Identity<StudentsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<StudentsRecord> getPrimaryKey() {
        return Keys.STUDENTS_PKEY;
    }

    @Override
    public List<UniqueKey<StudentsRecord>> getKeys() {
        return Arrays.<UniqueKey<StudentsRecord>>asList(Keys.STUDENTS_PKEY);
    }

    @Override
    public Students as(String alias) {
        return new Students(DSL.name(alias), this);
    }

    @Override
    public Students as(Name alias) {
        return new Students(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Students rename(String name) {
        return new Students(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Students rename(Name name) {
        return new Students(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
