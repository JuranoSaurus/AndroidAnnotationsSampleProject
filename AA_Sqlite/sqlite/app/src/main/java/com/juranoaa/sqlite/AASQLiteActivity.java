package com.juranoaa.sqlite;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.j256.ormlite.dao.Dao;
import com.juranoaa.sqlite.ormlite.House;
import com.juranoaa.sqlite.ormlite.HouseRuntimeExceptionDao;
import com.juranoaa.sqlite.ormlite.OrmLiteDBHelper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by SungGeun on 2015-10-10.
 */
@EActivity(R.layout.main)
public class AASQLiteActivity extends Activity {

    private static final String TAG = AASQLiteActivity.class.getSimpleName();

    @ViewById
    TextView textView;

    @OrmLiteDao(helper = OrmLiteDBHelper.class)
    Dao<House, Integer> houseDao;

    @OrmLiteDao(helper = OrmLiteDBHelper.class)
    HouseRuntimeExceptionDao houseExceptionDao;

    @AfterViews
    void afterViews() {
        try {
            List<House> houseList = houseDao.queryForAll();
            textView.setText(houseList.toString());
            for (House house : houseList) {
                House updateHouse = new House(house.getId(), house.getName() + "_update");
                houseDao.update(updateHouse);
            }
            List<House> updateHouseList = houseExceptionDao.queryForAll();
            textView.setText(textView.getText() + "\n" + updateHouseList);
        } catch (SQLException e){
            Log.e(TAG, e.getMessage(), e);
        }
    }

}
