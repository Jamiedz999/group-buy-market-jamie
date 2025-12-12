package com.jamie.domain.trade.service;

import com.jamie.domain.trade.adapter.repository.ITradeRepository;
import com.jamie.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.jamie.domain.trade.model.entity.*;
import com.jamie.domain.trade.model.valobj.GroupBuyProgressVO;
import com.jamie.domain.trade.service.factory.TradeRuleFilterFactory;
import com.jamie.types.design.framework.link.model2.chain.BusinessLinkedList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 17:04
 */

@Slf4j
@Service
public class TradeOrderService implements ITradeOrderService{

    @Resource
    private ITradeRepository repository;

    @Resource
    private BusinessLinkedList<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> tradeRuleFilter;


    @Override
    public MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo) {
        return repository.queryNoPayMarketPayOrderByOutTradeNo(userId, outTradeNo);
    }

    @Override
    public GroupBuyProgressVO queryGroupBuyProgress(String teamId) {
        return repository.queryGroupBuyProgress(teamId);
    }

    @Override
    public MarketPayOrderEntity lockMarketPayOrder(UserEntity userEntity, PayActivityEntity payActivityEntity, PayDiscountEntity payDiscountEntity) throws Exception {


        TradeRuleFilterBackEntity tradeRuleFilterBackEntity = tradeRuleFilter.apply(TradeRuleCommandEntity.builder()
                .activityId(payActivityEntity.getActivityId())
                .userId(userEntity.getUserId())
                .build(), new TradeRuleFilterFactory.DynamicContext());

        Integer userTakeOrderCount = tradeRuleFilterBackEntity.getUserTakeOrderCount();

        GroupBuyOrderAggregate groupBuyOrderAggregate = GroupBuyOrderAggregate.builder()
                .userEntity(userEntity)
                .payActivityEntity(payActivityEntity)
                .payDiscountEntity(payDiscountEntity)
                .userTakeOrderCount(userTakeOrderCount)
                .build();

        return repository.lockMarketPayOrder(groupBuyOrderAggregate);
    }
}
