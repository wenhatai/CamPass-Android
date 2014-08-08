package main.java.net.bingyan.campass.rest;

import android.app.Application;

import com.google.gson.Gson;

import net.bingyan.campass.Cache;
import net.bingyan.campass.CacheDao;

import java.util.Date;

import main.java.net.bingyan.campass.MyApplication;

/**
 * Created by ant on 14-8-8.
 */
public class CacheDaoHelper {
    Application app;

    public CacheDaoHelper(Application app) {
        this.app = app;
    }

    private CacheDao getCacheDao(){
        return ((MyApplication) app).getDaoSession().getCacheDao();
    }





    public <T> T getCache(Class<T> t) {
        Cache cache = getCacheDao().queryBuilder()
                .where(CacheDao.Properties.Name.eq(t.getName()))
                .unique();
        if (cache!=null) {
            return new Gson().fromJson(cache.getJson(), t);
        }
        return null;
    }

    public <T> T getCache(Class<T> t,String tag) {
        Cache cache = getCacheDao().queryBuilder()
                .where(CacheDao.Properties.Name.eq(t.getName()+tag))
                .unique();
        if (cache!=null) {
            return new Gson().fromJson(cache.getJson(), t);
        }
        return null;
    }

    public <T> T getCache(Class<T> t,long time) {
        Cache cache = getCacheDao().queryBuilder()
                .where(CacheDao.Properties.Name.eq(t.getName()))
                .unique();
        //getTime() milliseconds 毫秒
        if (cache!=null&&(new Date().getTime()-cache.getDate().getTime()<time)) {
            return new Gson().fromJson(cache.getJson(), t);
        }
        return null;
    }

    public <T> void putCache(T t) {
        Cache newsListCache = new Cache();
        newsListCache.setName(t.getClass().getName());
        newsListCache.setJson(new Gson().toJson(t));
        newsListCache.setDate(new Date());
        getCacheDao().update(newsListCache);
    }

    public <T> void putCache(T t,String tag) {
        Cache newsListCache = new Cache();
        newsListCache.setName(t.getClass().getName()+tag);
        newsListCache.setJson(new Gson().toJson(t));
        newsListCache.setDate(new Date());
        getCacheDao().update(newsListCache);
    }
}
