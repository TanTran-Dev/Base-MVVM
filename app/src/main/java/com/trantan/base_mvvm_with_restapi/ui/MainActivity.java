package com.trantan.base_mvvm_with_restapi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.trantan.base_mvvm_with_restapi.R;
import com.trantan.base_mvvm_with_restapi.adapter.TradeMarkAdapter;
import com.trantan.base_mvvm_with_restapi.model.trademark.TradeMark;
import com.trantan.base_mvvm_with_restapi.viewmodel.TradeMarkViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rcl_trademark)
    RecyclerView rclTrademark;

    private TradeMarkAdapter adapter;
    private TradeMarkViewModel tradeMarkViewModel;
    private List<TradeMark> tradeMarkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tradeMarkViewModel = ViewModelProviders.of(this).get(TradeMarkViewModel.class);
        tradeMarkViewModel.init();
        tradeMarkViewModel.getData().observe(this, new Observer<List<TradeMark>>() {
            @Override
            public void onChanged(List<TradeMark> tradeMarks) {
                tradeMarkList.addAll(tradeMarks);
                adapter.notifyDataSetChanged();
            }
        });

        tradeMarkList = new ArrayList<>();
        adapter = new TradeMarkAdapter(this, tradeMarkList);

        rclTrademark.setLayoutManager(new LinearLayoutManager(this));
        rclTrademark.setAdapter(adapter);


    }
}