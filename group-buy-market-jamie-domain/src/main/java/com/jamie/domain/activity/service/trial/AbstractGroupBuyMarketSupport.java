package com.jamie.domain.activity.service.trial;

import com.jamie.domain.activity.adapter.repository.IActivityRepository;
import com.jamie.domain.activity.model.entity.MarketProductEntity;
import com.jamie.domain.activity.model.entity.TrialBalanceEntity;
import com.jamie.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.jamie.types.design.framwork.tree.AbstractMultiThreadStrategyRouter;
import com.jamie.types.design.framwork.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 10:09
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity,  DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<com.jamie.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, com.jamie.domain.activity.model.entity.TrialBalanceEntity> {

    protected long timeout = 500;

    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(com.jamie.domain.activity.model.entity.MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {

    }
}
