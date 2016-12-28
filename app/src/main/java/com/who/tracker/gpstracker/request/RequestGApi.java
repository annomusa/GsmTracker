package com.who.tracker.gpstracker.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raffi on 12/26/2016.
 */

public class RequestGApi {

    @SerializedName("considerIp")
    @Expose
    private String considerIp = "false";
    @SerializedName("cellTowers")
    @Expose
    private List<CellTower> cellTowers = new ArrayList<>();

    public String getConsiderIp() {
        return considerIp;
    }

    public void setConsiderIp(String considerIp) {
        this.considerIp = considerIp;
    }

    public List<CellTower> getCellTowers() {
        return cellTowers;
    }

    public void setCellTowers(List<CellTower> cellTowers) {
        this.cellTowers = cellTowers;
    }

}
