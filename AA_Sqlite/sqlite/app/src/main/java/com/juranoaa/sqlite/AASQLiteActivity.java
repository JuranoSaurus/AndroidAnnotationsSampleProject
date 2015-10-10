package com.juranoaa.sqlite;

import android.app.Activity;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.juranoaa.sqlite.ormlite.House;
import com.juranoaa.sqlite.ormlite.OrmLiteDBHelper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by SungGeun on 2015-10-10.
 */
@EActivity(R.layout.main)
public class AASQLiteActivity extends OrmLiteBaseActivity<OrmLiteDBHelper> {

    @ViewById
    TextView textView;

    @AfterViews
    void afterViews(){
        RuntimeExceptionDao<House, Integer> houseDao = getHelper().getHouseDataDao();
        List<House> houseList = houseDao.queryForAll();
        textView.setText(houseList.toString());

        for(House house : houseList){
            House updateHouse = new House(house.getId(), house.getName()+"_update");
            houseDao.update(updateHouse);
        }
        List<House> updateHouseList = houseDao.queryForAll();
        textView.setText(textView.getText()+"\n"+updateHouseList);
    }


}
