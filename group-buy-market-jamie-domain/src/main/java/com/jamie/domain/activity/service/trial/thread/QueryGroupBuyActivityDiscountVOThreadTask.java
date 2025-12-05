package com.jamie.domain.activity.service.trial.thread;

import com.jamie.domain.activity.adapter.repository.IActivityRepository;
import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.jamie.domain.activity.model.valobj.SCSkuActivityVO;

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

    private final String goodsId;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel,String goodsId, IActivityRepository repository) {
        this.source = source;
        this.channel = channel;
        this.goodsId = goodsId;
        this.repository = repository;
    }


    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {

        SCSkuActivityVO scSkuActivityVO =  repository.querySCSkuActivityBySCGoodsId(source, channel, goodsId);

        if(null == scSkuActivityVO) return null;

        return repository.queryGroupBuyActivityDiscountVO(scSkuActivityVO.getActivityId());
    }
}
