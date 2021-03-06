package net.bingyan.campass;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import net.bingyan.campass.Cache;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table CACHE.
*/
public class CacheDao extends AbstractDao<Cache, String> {

    public static final String TABLENAME = "CACHE";

    /**
     * Properties of entity Cache.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Name = new Property(0, String.class, "name", true, "NAME");
        public final static Property Json = new Property(1, String.class, "json", false, "JSON");
        public final static Property Date = new Property(2, java.util.Date.class, "date", false, "DATE");
    };


    public CacheDao(DaoConfig config) {
        super(config);
    }
    
    public CacheDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'CACHE' (" + //
                "'NAME' TEXT PRIMARY KEY NOT NULL ," + // 0: name
                "'JSON' TEXT," + // 1: json
                "'DATE' INTEGER);"); // 2: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'CACHE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Cache entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getName());
 
        String json = entity.getJson();
        if (json != null) {
            stmt.bindString(2, json);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(3, date.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Cache readEntity(Cursor cursor, int offset) {
        Cache entity = new Cache( //
            cursor.getString(offset + 0), // name
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // json
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)) // date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Cache entity, int offset) {
        entity.setName(cursor.getString(offset + 0));
        entity.setJson(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDate(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Cache entity, long rowId) {
        return entity.getName();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Cache entity) {
        if(entity != null) {
            return entity.getName();
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
