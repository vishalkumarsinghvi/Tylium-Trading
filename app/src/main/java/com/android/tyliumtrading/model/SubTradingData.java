package com.android.tyliumtrading.model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SubTradingData implements Serializable {
    @SerializedName("symbol")
    private String symbol;

    @SerializedName("bid")
    private String bid;

    @SerializedName("ask")
    private String ask;

    @SerializedName("bidq")
    private String bidq;

    @SerializedName("askq")
    private String askq;

    @SerializedName("open")
    private String open;

    @SerializedName("timestamp")
    private String timestamp;

    public String getSymbol() {
        return symbol;
    }

    public String getBid() {
        return bid;
    }

    public String getAsk() {
        return ask;
    }

    public String getBidq() {
        return bidq;
    }

    public String getAskq() {
        return askq;
    }

    public String getOpen() {
        return open;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

