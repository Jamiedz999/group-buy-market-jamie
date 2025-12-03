package com.jamie.domain.activity.service.trial.node;

import com.jamie.domain.activity.model.entity.TrialBalanceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 10:28
 */
@Service
@Slf4j
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity>  {
}
