package com.who.tracker.gpstracker;

import com.who.tracker.gpstracker.request.RequestGApi;
import com.who.tracker.gpstracker.response.ResponseGApi;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

import static com.who.tracker.gpstracker.Constant.GOOGLE_API_KEY;

/**
 * Created by Raffi on 12/26/2016.
 */

public interface RestApi {

    @POST("geolocate?key=" + GOOGLE_API_KEY)
    Observable<ResponseGApi> getLocation(@Body RequestGApi requestGApi);
}
