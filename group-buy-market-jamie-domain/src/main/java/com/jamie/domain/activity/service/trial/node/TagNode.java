package com.jamie.domain.activity.service.trial.node;

import com.jamie.domain.activity.model.entity.MarketProductEntity;
import com.jamie.domain.activity.model.entity.TrialBalanceEntity;
import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.jamie.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.jamie.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.jamie.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 18:21
 */

@Service
@Slf4j
public class TagNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private EndNode endNode;



    @Override
    protected TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

        GroupBuyActivityDiscountVO groupBuyActivityDiscountVO = dynamicContext.getGroupBuyActivityDiscountVO();

        String tagId = groupBuyActivityDiscountVO.getTagId();

        boolean visible = groupBuyActivityDiscountVO.isVisible();
        boolean enable = groupBuyActivityDiscountVO.isEnable();

        if (StringUtils.isBlank(tagId)) {
            dynamicContext.setVisible(true);
            dynamicContext.setEnable(true);
            return router(requestParameter,dynamicContext);
        }

        boolean isWithin = repository.isTagCrowRange(tagId, requestParameter.getUserId());

        dynamicContext.setVisible(visible || isWithin);
        dynamicContext.setEnable(enable|| isWithin);

        return router(requestParameter,dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) {
        return endNode;
    }
}
