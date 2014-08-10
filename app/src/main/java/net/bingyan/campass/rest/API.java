package net.bingyan.campass.rest;

import net.bingyan.campass.module.electric.ElectricBean;

import java.util.Map;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by Jinge on 2014/8/9.
 */
public class API {
    public interface ElectricService {
        @GET("/check_dianfei")
        void getElectricJson(
                @QueryMap Map<String, String> options,
                Callback<ElectricBean> cb);
    }
}
