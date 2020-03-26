package com.android.tyliumtrading.model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SubData implements Serializable {
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

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("assetClass")
    private String assetClass;

    @SerializedName("canonical_symbol")
    private String canonical_symbol;

}

