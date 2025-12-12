package com.jamie.domain.activity.service.trial.node;

import com.jamie.domain.activity.model.entity.MarketProductEntity;
import com.jamie.domain.activity.model.entity.TrialBalanceEntity;
import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.jamie.domain.activity.model.valobj.SkuVO;
import com.jamie.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.jamie.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.jamie.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 10:28
 */
@Service
@Slf4j
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {



    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

        GroupBuyActivityDiscountVO groupBuyActivityDiscountVO = dynamicContext.getGroupBuyActivityDiscountVO();
        SkuVO skuVO = dynamicContext.getSkuVO();

        BigDecimal deductionPrice = dynamicContext.getDeductionPrice();
        BigDecimal payPrice = dynamicContext.getPayPrice();
        // 返回空结果
        return TrialBalanceEntity.builder()
                .goodsId(skuVO.getGoodsId())
                .goodsName(skuVO.getGoodsName())
                .originalPrice(skuVO.getOriginalPrice())
                .deductionPrice(deductionPrice)
                .payPrice(payPrice)
                .targetCount(groupBuyActivityDiscountVO.getTarget())
                .startTime(groupBuyActivityDiscountVO.getStartTime())
                .endTime(groupBuyActivityDiscountVO.getEndTime())
                .isVisible(dynamicContext.isVisible())
                .isEnable(dynamicContext.isEnable())
                .groupBuyActivityDiscountVO(groupBuyActivityDiscountVO)
                .build();

    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return defaultStrategyHandler;
    }
}
