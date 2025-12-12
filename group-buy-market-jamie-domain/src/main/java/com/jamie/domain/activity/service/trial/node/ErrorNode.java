package com.jamie.domain.activity.service.trial.node;

import com.alibaba.fastjson.JSON;
import com.jamie.domain.activity.model.entity.MarketProductEntity;
import com.jamie.domain.activity.model.entity.TrialBalanceEntity;
import com.jamie.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.jamie.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.jamie.types.design.framework.tree.StrategyHandler;
import com.jamie.types.enums.ResponseCode;
import com.jamie.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 17:01
 */

@Slf4j
@Service
public class ErrorNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {


    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务 Error userId：{} requestParameter:{}", requestParameter.getUserId(), JSON.toJSONString(requestParameter));

        if(null == dynamicContext.getGroupBuyActivityDiscountVO() || null == dynamicContext.getSkuVO()){
            throw new AppException(ResponseCode.E0002.getCode(), ResponseCode.E0002.getInfo());
        }

        return TrialBalanceEntity.builder().build();
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return null;
    }
}
