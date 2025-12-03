package com.jamie.domain.activity.service;

import com.jamie.domain.activity.model.entity.MarketProductEntity;
import com.jamie.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 10:29
 */
public interface IIndexGroupBuyMarketService {
    TrialBalanceEntity indexMatketTrial(MarketProductEntity marketProductEntity) throws Exception;
}
