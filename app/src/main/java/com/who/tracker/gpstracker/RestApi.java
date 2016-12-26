package com.who.tracker.gpstracker;

import com.who.tracker.gpstracker.response.RequestGApi;
import com.who.tracker.gpstracker.response.ResponseGApi;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Raffi on 12/26/2016.
 */

public interface RestApi {

    @POST("/")
    Observable<ResponseGApi> getLocation(@Body RequestGApi requestGApi);
}
