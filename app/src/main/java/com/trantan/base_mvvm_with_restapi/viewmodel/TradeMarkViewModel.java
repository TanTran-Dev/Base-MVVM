package com.trantan.base_mvvm_with_restapi.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.trantan.base_mvvm_with_restapi.model.TradeMark;
import com.trantan.base_mvvm_with_restapi.repository.TrademarkRepository;

import java.util.List;

public
class TradeMarkViewModel extends ViewModel {
    private MutableLiveData<List<TradeMark>> data;
    private TrademarkRepository trademarkRepository;

    public void init(){
        if (this.data != null){
            return;
        }
        trademarkRepository = TrademarkRepository.getInstance();
        data = trademarkRepository.getTrademarks();
    }

    public MutableLiveData<List<TradeMark>> getData() {
        return data;
    }
}
