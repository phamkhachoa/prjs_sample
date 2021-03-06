package com.viettel.wms.business;

import com.viettel.service.base.dto.DataListDTO;
import com.viettel.wms.dto.StockGoodsTotalDTO;

public interface StockGoodsTotalBusiness {

    long count();

    boolean updateStockGoodsTotal(StockGoodsTotalDTO stockGoodsTotalDTO);

    DataListDTO doSearchTotal(StockGoodsTotalDTO obj);

    StockGoodsTotalDTO getGood(Long stockId, Long goodsId, String goodsStateName, String goodsCode, String goodsName);

}
