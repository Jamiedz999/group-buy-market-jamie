package com.jamie.domain.trade.service.filter;

import com.jamie.domain.trade.adapter.repository.ITradeRepository;
import com.jamie.domain.trade.model.entity.GroupBuyActivityEntity;
import com.jamie.domain.trade.model.entity.TradeRuleCommandEntity;
import com.jamie.domain.trade.model.entity.TradeRuleFilterBackEntity;
import com.jamie.domain.trade.service.factory.TradeRuleFilterFactory;
import com.jamie.types.design.framework.link.model2.handler.ILogicHandler;
import com.jamie.types.enums.ActivityStatusEnumVO;
import com.jamie.types.enums.ResponseCode;
import com.jamie.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description:
 * @author: Jamie
 * @date: 11/12/2025 14:38
 */

@Slf4j
@Service
public class ActivityUsabilityRuleFilter implements ILogicHandler<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> {

    @Resource
    private ITradeRepository repository;
    @Override
    public TradeRuleFilterBackEntity apply(TradeRuleCommandEntity requestParameter, TradeRuleFilterFactory.DynamicContext dynamicContext) throws Exception {

        log.info("trade rule filter, activity availability, userId:{} activityId: {}", requestParameter.getUserId(),requestParameter.getActivityId());

        GroupBuyActivityEntity groupBuyActivity = repository.queryGroupBuyActivityByActivityId(requestParameter.getActivityId());

        if(!ActivityStatusEnumVO.EFFECTIVE.equals(groupBuyActivity.getStatus())){
            throw new AppException(ResponseCode.E0101);
        }

        Date currentTime = new Date();

        if(currentTime.before(groupBuyActivity.getStartTime()) || currentTime.after(groupBuyActivity.getEndTime())) {
            throw new AppException(ResponseCode.E0102);
        }

        dynamicContext.setGroupBuyActivity(groupBuyActivity);

        return next(requestParameter,dynamicContext);
    }
}
