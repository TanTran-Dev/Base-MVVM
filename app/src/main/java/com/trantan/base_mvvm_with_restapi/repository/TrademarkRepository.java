package com.trantan.base_mvvm_with_restapi.repository;

import androidx.lifecycle.MutableLiveData;

import com.trantan.base_mvvm_with_restapi.model.Page;
import com.trantan.base_mvvm_with_restapi.model.ResponseBody;
import com.trantan.base_mvvm_with_restapi.model.trademark.TradeMark;
import com.trantan.base_mvvm_with_restapi.network.ApiClient;
import com.trantan.base_mvvm_with_restapi.network.api_interface.TradeMarkService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public
class TrademarkRepository {
    private static TrademarkRepository instance;
    public static TrademarkRepository getInstance(){
        if (instance == null){
            instance = new TrademarkRepository();
        }
        return instance;
    }

    private CompositeDisposable compositeDisposable;


    public TrademarkRepository() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public MutableLiveData<List<TradeMark>> getTrademarks() {
        final MutableLiveData<List<TradeMark>> data = new MutableLiveData<>();

        Disposable disposable = ApiClient.getInstance()
                .create(TradeMarkService.class)
                .getTrademarks(null, null, 0, 50)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                        new Consumer<ResponseBody<Page<TradeMark>>>() {
                            @Override
                            public void accept(ResponseBody<Page<TradeMark>> pageResponseBody) throws Exception {
                                if (pageResponseBody != null){
                                    data.setValue(pageResponseBody.getData().getItems());
                                }
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                throwable.printStackTrace();
                            }
                        });

        compositeDisposable.add(disposable);

        return data;
    }
}
