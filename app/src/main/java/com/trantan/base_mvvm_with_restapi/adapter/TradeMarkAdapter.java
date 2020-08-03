package com.trantan.base_mvvm_with_restapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.trantan.base_mvvm_with_restapi.R;
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
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trademark, parent, false);
        return new TrademarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrademarkViewHolder holder, int position) {
        TradeMark tradeMark = tradeMarks.get(position);

        RequestOptions requestOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(holder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(tradeMark.getImageUrl())
                .into(holder.imgTrademark);

        holder.txtTrademarkName.setText(tradeMark.getName());
    }

    @Override
    public int getItemCount() {
        return tradeMarks.size();
    }

    static class TrademarkViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_trademark)
        CircleImageView imgTrademark;
        @BindView(R.id.txt_trademark_name)
        TextView txtTrademarkName;

        public TrademarkViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
