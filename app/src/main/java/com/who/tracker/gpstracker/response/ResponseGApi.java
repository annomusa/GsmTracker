package com.who.tracker.gpstracker.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Raffi on 12/26/2016.
 */

public class ResponseGApi {
    @SerializedName("locationGApi")
    @Expose
    private LocationGApi locationGApi;

    @SerializedName("accuracy")
    @Expose
    private Double accuracy;

    public LocationGApi getLocationGApi() {
        return locationGApi;
    }

    public void setLocationGApi(LocationGApi locationGApi) {
        this.locationGApi = locationGApi;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }
}
