package com.izv.dam.newquip.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.izv.dam.newquip.pojo.PojoMaps;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Created by dam on 5/12/16.
 */

public class AyudanteMaps extends OrmLiteSqliteOpenHelper {
    public static final int VERSION = 1;

    private Dao<PojoMaps,Integer> simpleDao = null;
    private RuntimeExceptionDao<PojoMaps,Integer> simpleRunTimeDao=null;

    public AyudanteMaps(Context context) {
        super(context, "localizaciones", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,PojoMaps.class);
        }catch (java.sql.SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, PojoMaps.class, true);
            onCreate(database,connectionSource);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<PojoMaps, Integer> getSimpleDao() throws java.sql.SQLException {
        if (simpleDao == null){
            simpleDao=getDao(PojoMaps.class);
        }
        return simpleDao;
    }

    public RuntimeExceptionDao<PojoMaps, Integer> getSimpleRunTimeDao() {
        if (simpleRunTimeDao==null){
            simpleRunTimeDao=getRuntimeExceptionDao(PojoMaps.class);
        }
        return simpleRunTimeDao;
    }

    @Override
    public void close(){
        super.close();
        simpleDao = null;
        simpleRunTimeDao = null;
    }
}
