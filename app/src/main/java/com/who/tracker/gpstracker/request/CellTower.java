package com.who.tracker.gpstracker.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Raffi on 12/27/2016.
 */
public class CellTower {
    @SerializedName("cellId")
    @Expose
    private Integer cellId;
    @SerializedName("locationAreaCode")
    @Expose
    private Integer locationAreaCode;
    @SerializedName("mobileCountryCode")
    @Expose
    private Integer mobileCountryCode;
    @SerializedName("mobileNetworkCode")
    @Expose
    private Integer mobileNetworkCode;

    public Integer getCellId() {
        return cellId;
    }

    public void setCellId(Integer cellId) {
        this.cellId = cellId;
    }

    public Integer getLocationAreaCode() {
        return locationAreaCode;
    }

    public void setLocationAreaCode(Integer locationAreaCode) {
        this.locationAreaCode = locationAreaCode;
    }

    public Integer getMobileCountryCode() {
        return mobileCountryCode;
    }

    public void setMobileCountryCode(Integer mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    public Integer getMobileNetworkCode() {
        return mobileNetworkCode;
    }

    public void setMobileNetworkCode(Integer mobileNetworkCode) {
        this.mobileNetworkCode = mobileNetworkCode;
    }
}
