package com.who.tracker.gpstracker.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Raffi on 12/26/2016.
 */

public class ResponseGApi {
    @SerializedName("location")
    @Expose
    private LocationGApi locationGApi;

    @SerializedName("accuracy")
    @Expose
    private Double accuracy;

    @SerializedName("error")
    @Expose
    private String error;

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (locationGApi != null) stringBuilder.append(locationGApi.toString());
        if (accuracy != null) stringBuilder.append(accuracy.toString());
        if (error != null) stringBuilder.append(error);
        return stringBuilder.toString();
    }
}
