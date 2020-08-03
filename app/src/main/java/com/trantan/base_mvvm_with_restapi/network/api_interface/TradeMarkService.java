package com.trantan.base_mvvm_with_restapi.network.api_interface;

import com.trantan.base_mvvm_with_restapi.model.Page;
import com.trantan.base_mvvm_with_restapi.model.ResponseBody;
import com.trantan.base_mvvm_with_restapi.model.trademark.TradeMark;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public
interface TradeMarkService {
    @GET("/api/trademark/trademarks")
    Observable<ResponseBody<Page<TradeMark>>> getTrademarks(
            @Query("sortBy") String sortBy,
            @Query("sortType") String sortType,
            @Query("pageIndex") int pageIndex,
            @Query("pageSize") int pageSize
    );
}
