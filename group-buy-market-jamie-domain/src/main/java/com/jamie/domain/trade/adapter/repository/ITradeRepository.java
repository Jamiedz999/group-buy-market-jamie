package com.jamie.domain.trade.adapter.repository;

import com.jamie.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.jamie.domain.trade.model.entity.MarketPayOrderEntity;
import com.jamie.domain.trade.model.valobj.GroupBuyProgressVO;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 17:05
 */
public interface ITradeRepository {

    MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo);

    GroupBuyProgressVO queryGroupBuyProgress(String teamId);

    MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate);
}
