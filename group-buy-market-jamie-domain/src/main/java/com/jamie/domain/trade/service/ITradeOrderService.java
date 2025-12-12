package com.jamie.domain.trade.service;

import com.jamie.domain.trade.model.entity.MarketPayOrderEntity;
import com.jamie.domain.trade.model.entity.PayActivityEntity;
import com.jamie.domain.trade.model.entity.PayDiscountEntity;
import com.jamie.domain.trade.model.entity.UserEntity;
import com.jamie.domain.trade.model.valobj.GroupBuyProgressVO;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 16:46
 */


public interface ITradeOrderService {

    MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    MarketPayOrderEntity lockMarketPayOrder(UserEntity userEntity, PayActivityEntity payActivityEntity, PayDiscountEntity payDiscountEntity) throws Exception;

}
