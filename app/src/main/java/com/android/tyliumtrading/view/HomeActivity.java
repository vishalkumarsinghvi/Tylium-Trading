package com.android.tyliumtrading.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.tyliumtrading.R;
import com.android.tyliumtrading.model.TradingData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HomeActivity extends AppCompatActivity {
private ArrayList<TradingData> tradingData=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String res = getIntent().getExtras().getString("data");
        JsonObject jsonObject = new Gson().fromJson(res, JsonObject.class);
//        jsonObject.get("prices").getAsJsonObject().get("FCHI").getAsJsonObject().get("bid")
//        for (int i = 0; i < jsonObject.getAsJsonObject().size(); i++) {
//            JsonObject jsonInstruments = jsonObject.get("instruments").getAsJsonObject();
//            JsonObject jsonPrices = jsonObject.get("prices").getAsJsonObject();
//            for (int j = 0; j < jsonInstruments.size(); j++) {
//                TradingData tradingData=new TradingData();
////                tradingData.setId(jsonInstruments.);
//            }
////
//        }

        Map<String, Object> attributes = new HashMap<String, Object>();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        for(Map.Entry<String,JsonElement> entry : entrySet){
//            if (! nonProperties.contains(entry.getKey())) {
//                properties.put(entry.getKey(), jsonObject.get(entry.getKey()).replace("\"",""));
//            }
            entry.getKey();
        }
    }
}
