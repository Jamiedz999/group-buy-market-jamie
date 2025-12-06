package com.jamie.domain.activity.adapter.repository;

import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.jamie.domain.activity.model.valobj.SCSkuActivityVO;
import com.jamie.domain.activity.model.valobj.SkuVO;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 16:43
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuBugoodsId(String goodsId);


    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowRange(String tagId, String userId);
}
