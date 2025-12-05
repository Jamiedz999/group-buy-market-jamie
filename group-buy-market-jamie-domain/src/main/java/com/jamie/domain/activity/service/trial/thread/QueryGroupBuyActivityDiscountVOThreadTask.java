package com.jamie.domain.activity.service.trial.thread;

import com.jamie.domain.activity.adapter.repository.IActivityRepository;
import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 17:40
 */
public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    private final String source;

    private final String channel;

    private final IActivityRepository repository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel, IActivityRepository repository) {
        this.source = source;
        this.channel = channel;
        this.repository = repository;
    }


    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        return repository.queryGroupBuyActivityDiscountVO(source,channel);
    }
}
