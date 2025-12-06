package com.jamie.infrastructure.adapter.repository;

import com.jamie.domain.activity.adapter.repository.IActivityRepository;
import com.jamie.domain.activity.model.valobj.DiscountTypeEnum;
import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.jamie.domain.activity.model.valobj.SCSkuActivityVO;
import com.jamie.domain.activity.model.valobj.SkuVO;
import com.jamie.infrastructure.dao.IGroupBuyActivityDao;
import com.jamie.infrastructure.dao.IGroupBuyDiscountDao;
import com.jamie.infrastructure.dao.ISCSkuActivityDao;
import com.jamie.infrastructure.dao.ISkuDao;
import com.jamie.infrastructure.dao.po.GroupBuyActivity;
import com.jamie.infrastructure.dao.po.GroupBuyDiscount;
import com.jamie.infrastructure.dao.po.SCSkuActivity;
import com.jamie.infrastructure.dao.po.Sku;
import com.jamie.infrastructure.redis.IRedisService;
import org.redisson.api.RBitSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 17:44
 */

@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;

    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;

    @Resource
    private ISkuDao skuDao;

    @Resource
    private ISCSkuActivityDao skuActivityDao;

    @Resource
    private IRedisService redisService;

    @Override
    public GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId) {

        GroupBuyActivity groupBuyActivityRes = groupBuyActivityDao.queryValidGroupBuyActivityId(activityId);

        if(null == groupBuyActivityRes) return null;


        String discountId = groupBuyActivityRes.getDiscountId();

        GroupBuyDiscount groupBuyDiscountRes = groupBuyDiscountDao.queryGroupBuyActivityByDiscountId(discountId);

        if(null == groupBuyDiscountRes) return null;



        GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount = GroupBuyActivityDiscountVO.GroupBuyDiscount.builder()
                .discountName(groupBuyDiscountRes.getDiscountName())
                .discountDesc(groupBuyDiscountRes.getDiscountDesc())
                .discountType(DiscountTypeEnum.get(groupBuyDiscountRes.getDiscountType()))
                .marketPlan(groupBuyDiscountRes.getMarketPlan())
                .marketExpr(groupBuyDiscountRes.getMarketExpr())
                .tagId(groupBuyDiscountRes.getTagId())
                .build();

        return GroupBuyActivityDiscountVO.builder()
                .activityId(groupBuyActivityRes.getActivityId())
                .activityName(groupBuyActivityRes.getActivityName())

                .groupBuyDiscount(groupBuyDiscount)
                .groupType(groupBuyActivityRes.getGroupType())
                .takeLimitCount(groupBuyActivityRes.getTakeLimitCount())
                .target(groupBuyActivityRes.getTarget())
                .validTime(groupBuyActivityRes.getValidTime())
                .status(groupBuyActivityRes.getStatus())
                .startTime(groupBuyActivityRes.getStartTime())
                .endTime(groupBuyActivityRes.getEndTime())
                .tagId(groupBuyActivityRes.getTagId())
                .tagScope(groupBuyActivityRes.getTagScope())
                .build();

    }

    @Override
    public SkuVO querySkuBugoodsId(String goodsId) {
        Sku sku = skuDao.querySkuByGoodsId(goodsId);
        if(null == sku) return null;
        return SkuVO.builder()
                .goodsId(sku.getGoodsId())
                .goodsName(sku.getGoodsName())
                .originalPrice(sku.getOriginalPrice())
                .build();
    }

    @Override
    public SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId) {

        SCSkuActivity scSkuActivityReq = new SCSkuActivity();

        scSkuActivityReq.setSource(source);
        scSkuActivityReq.setChannel(channel);
        scSkuActivityReq.setGoodsId(goodsId);
        SCSkuActivity scSkuActivity = skuActivityDao.querySCSkuActivityBySCGoodsId(scSkuActivityReq);

        if(null == scSkuActivity) return null;

        return  SCSkuActivityVO.builder()
                .source(scSkuActivity.getSource())
                .activityId(scSkuActivity.getActivityId())
                .goodsId(scSkuActivity.getGoodsId())
                .channel(scSkuActivity.getChannel())
                .build();



    }

    @Override
    public boolean isTagCrowRange(String tagId, String userId) {

        RBitSet bitSet = redisService.getBitSet(tagId);
        if(!bitSet.isExists()) return true;

        return bitSet.get(redisService.getIndexFromUserId(userId));
    }
}
