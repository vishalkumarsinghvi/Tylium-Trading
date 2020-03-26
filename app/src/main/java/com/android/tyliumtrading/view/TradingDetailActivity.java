package com.android.tyliumtrading.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.tyliumtrading.R;
import com.android.tyliumtrading.model.TradingData;

public class TradingDetailActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trading_detail);
        initUI();
    }

    private void initUI() {
        TradingData res = (TradingData) getIntent().getExtras().getSerializable("data");
        TextView tvHeaderName = findViewById(R.id.tv_header_name);
        TextView tvId = findViewById(R.id.tv_id);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvSymbol = findViewById(R.id.tv_symbol);
        TextView tvAssestClass = findViewById(R.id.tv_assest);
        TextView tvPrice = findViewById(R.id.tv_price_inc);
        TextView tvQan = findViewById(R.id.tv_qan_inc);
        ImageView ivBack = findViewById(R.id.iv_back);
        tvHeaderName.setText(res.getName());
        tvName.setText(res.getName());
        tvId.setText(res.getId());
        tvAssestClass.setText(res.getAssetClass());
        tvSymbol.setText(res.getCanonical_symbol());
        tvPrice.setText(res.getPriceIncrement());
        tvQan.setText(res.getQuantityIncrement());
        ivBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            onBackPressed();
        }
    }
}
