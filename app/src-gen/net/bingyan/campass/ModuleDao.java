package net.bingyan.campass;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import net.bingyan.campass.Module;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MODULE.
*/
public class ModuleDao extends AbstractDao<Module, Long> {

    public static final String TABLENAME = "MODULE";

    /**
     * Properties of entity Module.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Frequency = new Property(2, Integer.class, "frequency", false, "FREQUENCY");
        public final static Property Iconid = new Property(3, Integer.class, "iconid", false, "ICONID");
        public final static Property Classname = new Property(4, String.class, "classname", false, "CLASSNAME");
    };


    public ModuleDao(DaoConfig config) {
        super(config);
    }
    
    public ModuleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MODULE' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'NAME' TEXT NOT NULL ," + // 1: name
                "'FREQUENCY' INTEGER," + // 2: frequency
                "'ICONID' INTEGER," + // 3: iconid
                "'CLASSNAME' TEXT);"); // 4: classname
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MODULE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Module entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        Integer frequency = entity.getFrequency();
        if (frequency != null) {
            stmt.bindLong(3, frequency);
        }
 
        Integer iconid = entity.getIconid();
        if (iconid != null) {
            stmt.bindLong(4, iconid);
        }
 
        String classname = entity.getClassname();
        if (classname != null) {
            stmt.bindString(5, classname);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Module readEntity(Cursor cursor, int offset) {
        Module entity = new Module( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // frequency
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // iconid
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // classname
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Module entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setFrequency(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setIconid(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setClassname(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Module entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Module entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
