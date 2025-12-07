package com.jamie.domain.activity.service.trial.node;

import com.jamie.domain.activity.model.entity.MarketProductEntity;
import com.jamie.domain.activity.model.entity.TrialBalanceEntity;
import com.jamie.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.jamie.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.jamie.types.design.framwork.tree.StrategyHandler;
import com.jamie.types.enums.ResponseCode;
import com.jamie.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 10:25
 */
@Slf4j
@Service
public class SwitchNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private MarketNode marketNode;

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {


        String userId = requestParameter.getUserId();
        if(repository.downgradeSwitch()) {
            throw new AppException(ResponseCode.E0003.getCode(), ResponseCode.E0003.getInfo());
        }

        if (!repository.cutRange(userId)){
            throw new AppException(ResponseCode.E0004.getCode(), ResponseCode.E0004.getInfo());
        }

        return router(requestParameter,dynamicContext);
     }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return marketNode;
    }
}
