package com.android.tyliumtrading.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.tyliumtrading.R;
import com.android.tyliumtrading.adapter.TradingAdapter;
import com.android.tyliumtrading.model.SubTradingData;
import com.android.tyliumtrading.model.TradingData;
import com.android.tyliumtrading.model.TradingDataComparator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<TradingData> tradingDataList = new ArrayList<>();
    private TextView tvName, tvSymbol, tvBid, tvAsk;
    private TradingAdapter tradingAdapter;
    private boolean isNameClicked;
    private boolean isSymbolClicked;
    private EditText editTextSearch;
    ArrayList<TradingData> tradingTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getListDataFromJson();
        tradingTemp=tradingDataList;
        initUI();
    }

    private void initUI() {
        tvName = findViewById(R.id.tv_trading_name);
        tvSymbol = findViewById(R.id.tv_trading_symbol);
        tvBid = findViewById(R.id.tv_trading_bid);
        tvAsk = findViewById(R.id.tv_trading_ask);
        editTextSearch = findViewById(R.id.editTextSearch);
        tvName.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up_down, 0);
        tvSymbol.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up_down, 0);
        tvName.setOnClickListener(this);
        tvSymbol.setOnClickListener(this);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });
        setUpTradingRecyclerView();
    }

    private void filter(String text) {
        tradingTemp=new ArrayList<>();
        for (TradingData tradingData : tradingDataList) {
            if (tradingData.getName().toLowerCase().contains(text.toLowerCase())) {
                tradingTemp.add(tradingData);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        tradingAdapter.filterList(tradingTemp);
    }

    private void setUpTradingRecyclerView() {
        RecyclerView rvRawData = findViewById(R.id.rv_trading_data);
        tradingAdapter = new TradingAdapter(this, tradingDataList);
        rvRawData
                .setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvRawData.setHasFixedSize(true);
        rvRawData.addItemDecoration(
                new DividerItemDecoration(this,
                        DividerItemDecoration.VERTICAL));
        rvRawData.setAdapter(tradingAdapter);
    }

    private void getListDataFromJson() {
        String res = getIntent().getExtras().getString("data");
        JsonObject jsonObject = new Gson().fromJson(res, JsonObject.class);
        for (Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
//            System.out.println(jsonObject.get(key));
            if (key.contains("instruments")) {
                JsonObject jsonObjectNew = new Gson().fromJson(jsonObject.get(key), JsonObject.class);
                JsonObject jsonObjectPrice = new Gson().fromJson(jsonObject.get("prices"), JsonObject.class);
                for (Iterator iteratorNew = jsonObjectNew.keySet().iterator(); iteratorNew.hasNext(); ) {
                    String keyNew = (String) iteratorNew.next();
                    System.out.println(jsonObjectNew.get(keyNew));
                    System.out.println(jsonObjectPrice.get(keyNew));
                    TradingData tradingData;
                    tradingData = new Gson().fromJson(jsonObjectNew.get(keyNew), TradingData.class);
                    tradingData.setSubTradingData(new Gson().fromJson(jsonObjectPrice.get(keyNew), SubTradingData.class));
                    tradingDataList.add(tradingData);
                }
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_trading_name:
                isNameClicked = !isNameClicked;
                Collections.sort(tradingTemp, new TradingDataComparator.NameSorter(isNameClicked));
                tradingAdapter.notifyDataSetChanged();
                break;
            case R.id.tv_trading_symbol:
                isSymbolClicked = !isSymbolClicked;
                Collections.sort(tradingTemp, new TradingDataComparator.SymbolSorted(isSymbolClicked));
                tradingAdapter.notifyDataSetChanged();
                break;
        }
    }
}
