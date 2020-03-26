package com.android.tyliumtrading.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.tyliumtrading.R;
import com.android.tyliumtrading.model.TradingData;
import com.android.tyliumtrading.view.TradingDetailActivity;

import java.util.ArrayList;

public class TradingAdapter extends RecyclerView.Adapter<TradingAdapter.ViewHolder> {

    private ArrayList<TradingData> tradingDataArrayList;
    private Context context;

    public TradingAdapter(Context context,
                          ArrayList<TradingData> tradingDataArrayList) {
        this.context = context;
        this.tradingDataArrayList = tradingDataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_trading_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if (tradingDataArrayList != null) {
            holder.tvTradingName
                    .setText(tradingDataArrayList.get(position).getName());
            holder.tvTradingSymbol
                    .setText(tradingDataArrayList.get(position).getCanonical_symbol());
            holder.tvTradingBid
                    .setText(tradingDataArrayList.get(position).getSubTradingData().getBid());
            holder.tvTradingAsk
                    .setText(tradingDataArrayList.get(position).getSubTradingData().getAsk());
            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, TradingDetailActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("data", tradingDataArrayList.get(position));
                intent.putExtras(b);
                context.startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return tradingDataArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTradingName, tvTradingSymbol, tvTradingBid, tvTradingAsk;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTradingName = itemView.findViewById(R.id.tv_trading_name);
            tvTradingSymbol = itemView.findViewById(R.id.tv_trading_symbol);
            tvTradingBid = itemView.findViewById(R.id.tv_trading_bid);
            tvTradingAsk = itemView.findViewById(R.id.tv_trading_ask);
        }
    }

    public void filterList(ArrayList<TradingData> tradingData) {
        this.tradingDataArrayList = tradingData;
        notifyDataSetChanged();
    }
}
