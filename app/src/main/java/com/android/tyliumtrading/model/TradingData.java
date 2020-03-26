package com.android.tyliumtrading.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TradingData implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("priceIncrement")
    private String priceIncrement;

    @SerializedName("quantityIncrement")
    private String quantityIncrement;

    @SerializedName("assetClass")
    private String assetClass;

    @SerializedName("canonical_symbol")
    private String canonical_symbol;
    private SubTradingData subTradingData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriceIncrement() {
        return priceIncrement;
    }

    public void setPriceIncrement(String priceIncrement) {
        this.priceIncrement = priceIncrement;
    }

    public String getQuantityIncrement() {
        return quantityIncrement;
    }

    public void setQuantityIncrement(String quantityIncrement) {
        this.quantityIncrement = quantityIncrement;
    }

    public String getCanonical_symbol() {
        return canonical_symbol;
    }

    public void setCanonical_symbol(String canonical_symbol) {
        this.canonical_symbol = canonical_symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public SubTradingData getSubTradingData() {
        return subTradingData;
    }

    public void setSubTradingData(SubTradingData subTradingData) {
        this.subTradingData = subTradingData;
    }
}
