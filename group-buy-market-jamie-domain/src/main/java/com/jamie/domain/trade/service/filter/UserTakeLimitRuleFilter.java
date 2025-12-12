package com.jamie.domain.trade.service.filter;

import com.jamie.domain.trade.adapter.repository.ITradeRepository;
import com.jamie.domain.trade.model.entity.GroupBuyActivityEntity;
import com.jamie.domain.trade.model.entity.TradeRuleCommandEntity;
import com.jamie.domain.trade.model.entity.TradeRuleFilterBackEntity;
import com.jamie.domain.trade.service.factory.TradeRuleFilterFactory;
import com.jamie.types.design.framework.link.model2.handler.ILogicHandler;
import com.jamie.types.enums.ResponseCode;
import com.jamie.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 11/12/2025 14:38
 */
@Slf4j
@Service
public class UserTakeLimitRuleFilter implements ILogicHandler<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity>  {

    @Resource
    private ITradeRepository repository;


    @Override
    public TradeRuleFilterBackEntity apply(TradeRuleCommandEntity requestParameter, TradeRuleFilterFactory.DynamicContext dynamicContext) throws Exception {
        log.info("trade rule filter, activity availability, userId:{} activityId: {}", requestParameter.getUserId(),requestParameter.getActivityId());

        GroupBuyActivityEntity groupBuyActivity = dynamicContext.getGroupBuyActivity();

        Integer count = repository.queryOrderCountByActivityId(requestParameter.getActivityId(),requestParameter.getUserId());

        if(null != groupBuyActivity.getTakeLimitCount() && count >=groupBuyActivity.getTakeLimitCount()){
            throw new AppException(ResponseCode.E0103);

        }

        return TradeRuleFilterBackEntity.builder().userTakeOrderCount(count).build();
    }
}
