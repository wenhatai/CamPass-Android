package net.bingyan.campass.rest;

import net.bingyan.campass.ElectricRecordDao;
import net.bingyan.campass.MyApplication;

import java.util.Date;

/**
 * Created by Jinge on 2014/8/9.
 */
public class ElectricRecordDaoHelper {

    private ElectricRecordDao electricRecordDao;
    public ElectricRecordDaoHelper(MyApplication myApplication) {
        electricRecordDao = myApplication.getDaoSession().getElectricRecordDao();
    }

    public void insert(String area, int building, int dorm, float remain, Date date) {
//        electricRecordDao.insertOrReplace();
    }

}
