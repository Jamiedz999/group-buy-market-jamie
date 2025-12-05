package com.jamie.domain.activity.service.trial.thread;

import com.jamie.domain.activity.adapter.repository.IActivityRepository;
import com.jamie.domain.activity.model.valobj.SkuVO;

import java.util.Calendar;
import java.util.concurrent.Callable;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 18:00
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;



    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuBugoodsId(goodsId);
    }
}
