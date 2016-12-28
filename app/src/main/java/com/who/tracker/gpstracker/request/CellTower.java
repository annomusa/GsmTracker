package com.who.tracker.gpstracker.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Raffi on 12/27/2016.
 */
public class CellTower {

    private Integer cellId;

    private Integer locationAreaCode;

    private Integer mobileCountryCode;

    private Integer mobileNetworkCode;

    public CellTower(Integer cellId, Integer locationAreaCode, Integer mobileCountryCode, Integer mobileNetworkCode) {
        this.cellId = cellId;
        this.locationAreaCode = locationAreaCode;
        this.mobileCountryCode = mobileCountryCode;
        this.mobileNetworkCode = mobileNetworkCode;
    }

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cellId + " "
                + locationAreaCode + " "
                + mobileCountryCode + " "
                + mobileNetworkCode);
        return stringBuilder.toString();
    }
}
