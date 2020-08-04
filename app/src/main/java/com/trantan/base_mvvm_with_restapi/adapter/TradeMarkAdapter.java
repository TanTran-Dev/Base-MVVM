package com.trantan.base_mvvm_with_restapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.trantan.base_mvvm_with_restapi.R;
import com.trantan.base_mvvm_with_restapi.databinding.ItemTrademarkBinding;
import com.trantan.base_mvvm_with_restapi.model.trademark.TradeMark;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public
class TradeMarkAdapter extends RecyclerView.Adapter<TradeMarkAdapter.TrademarkViewHolder> {
    private Context context;
    private List<TradeMark> tradeMarks;

    public TradeMarkAdapter(Context context, List<TradeMark> tradeMarks) {
        this.context = context;
        this.tradeMarks = tradeMarks;
    }

    @NonNull
    @Override
    public TrademarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTrademarkBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_trademark, parent, false);
        return new TrademarkViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrademarkViewHolder holder, int position) {
        holder.binding.setTrademark(tradeMarks.get(position));
    }

    @Override
    public int getItemCount() {
        return tradeMarks.size();
    }

    static class TrademarkViewHolder extends RecyclerView.ViewHolder{
        public ItemTrademarkBinding binding;
        public TrademarkViewHolder(ItemTrademarkBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
