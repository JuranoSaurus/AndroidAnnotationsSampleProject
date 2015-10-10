package com.juranoaa.sqlite.ormlite;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by SungGeun on 2015-10-10.
 */
public class HouseRuntimeExceptionDao extends RuntimeExceptionDao<House,Integer>{

    public HouseRuntimeExceptionDao(Dao<House, Integer> dao) {
        super(dao);
    }
}
