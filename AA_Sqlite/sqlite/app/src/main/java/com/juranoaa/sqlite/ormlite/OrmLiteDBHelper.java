package com.juranoaa.sqlite.ormlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.juranoaa.sqlite.common.Constant;

import java.sql.SQLException;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class OrmLiteDBHelper extends OrmLiteSqliteOpenHelper{

    private static final String TAG = OrmLiteDBHelper.class.getSimpleName();

    private Dao<House, Integer> houseDao = null;
    private RuntimeExceptionDao<House, Integer> houseRuntimeExceptionDao = null;

    public OrmLiteDBHelper(Context context) {
        super(context, Constant.SQLite.ORM_DB_NAME, null, Constant.SQLite.ORM_DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, House.class);
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage(), e);
            throw new RuntimeException(e);
        }

        // init database row
        RuntimeExceptionDao<House, Integer> dao = getHouseDataDao();
        House house = new House("MyHouse");
        dao.create(house);

        house = new House("YourHouse");
        dao.create(house);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, House.class, true);
            onCreate(database, connectionSource);
        }catch (SQLException e){
            Log.e(TAG, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public Dao<House, Integer> getDao() throws SQLException{
        if(houseDao == null){
            houseDao = getDao(House.class);
        }
        return houseDao;
    }

    public RuntimeExceptionDao<House, Integer> getHouseDataDao() {
        if (houseRuntimeExceptionDao == null) {
            houseRuntimeExceptionDao = getRuntimeExceptionDao(House.class);
        }
        return houseRuntimeExceptionDao;
    }

}
