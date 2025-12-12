package com.jamie.infrastructure.adapter.repository;

import com.jamie.domain.trade.adapter.repository.ITradeRepository;
import com.jamie.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import com.jamie.domain.trade.model.entity.*;
import com.jamie.domain.trade.model.valobj.GroupBuyProgressVO;
import com.jamie.domain.trade.model.valobj.TradeOrderStatusEnumVO;
import com.jamie.infrastructure.dao.IGroupBuyActivityDao;
import com.jamie.infrastructure.dao.IGroupBuyOrderDao;
import com.jamie.infrastructure.dao.IGroupBuyOrderListDao;
import com.jamie.infrastructure.dao.po.GroupBuyActivity;
import com.jamie.infrastructure.dao.po.GroupBuyOrder;
import com.jamie.infrastructure.dao.po.GroupBuyOrderList;
import com.jamie.types.common.Constants;
import com.jamie.types.enums.ActivityStatusEnumVO;
import com.jamie.types.enums.ResponseCode;
import com.jamie.types.exception.AppException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 17:10
 */

@Repository
public class TradeRepository implements ITradeRepository {

    @Resource
    private IGroupBuyOrderDao groupBuyOrderDao;
    @Resource
    private IGroupBuyOrderListDao groupBuyOrderListDao;

    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;



    @Override
    public MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo) {

        GroupBuyOrderList groupBuyOrderListReq = new GroupBuyOrderList();

        groupBuyOrderListReq.setUserId(userId);
        groupBuyOrderListReq.setOutTradeNo(outTradeNo);

        GroupBuyOrderList groupBuyOrderListRes = groupBuyOrderListDao.queryGroupBuyOrderRecordByOutTradeNo(groupBuyOrderListReq);

        if(null == groupBuyOrderListRes) return null;

        return  MarketPayOrderEntity.builder()
                .orderId(groupBuyOrderListRes.getOrderId())
                .deductionPrice(groupBuyOrderListRes.getDeductionPrice())
                .tradeOrderStatusEnumVO(TradeOrderStatusEnumVO.valueOf(groupBuyOrderListRes.getStatus()))
                .build();

    }

    @Override
    public GroupBuyProgressVO queryGroupBuyProgress(String teamId) {
        GroupBuyOrder groupBuyOrder = groupBuyOrderDao.queryGroupBuyProgress(teamId);
        if(groupBuyOrder == null) return null;


        return GroupBuyProgressVO.builder()
                .targetCount(groupBuyOrder.getTargetCount())
                .completeCount(groupBuyOrder.getCompleteCount())
                .lockCount(groupBuyOrder.getLockCount())
                .build();
    }

    @Transactional(timeout=500)
    @Override
    public MarketPayOrderEntity lockMarketPayOrder(GroupBuyOrderAggregate groupBuyOrderAggregate) {


        UserEntity userEntity = groupBuyOrderAggregate.getUserEntity();
        PayActivityEntity payActivityEntity = groupBuyOrderAggregate.getPayActivityEntity();
        PayDiscountEntity payDiscountEntity = groupBuyOrderAggregate.getPayDiscountEntity();
        Integer userTakeOrderCount = groupBuyOrderAggregate.getUserTakeOrderCount();


        String teamId = payActivityEntity.getTeamId();

        if(StringUtils.isBlank(teamId)) {
            teamId = RandomStringUtils.randomNumeric(8);

            GroupBuyOrder groupBuyOrder =  GroupBuyOrder.builder()
                    .teamId(teamId)
                    .activityId(payActivityEntity.getActivityId())
                    .source(payDiscountEntity.getSource())
                    .channel(payDiscountEntity.getChannel())
                    .originalPrice(payDiscountEntity.getOriginalPrice())
                    .deductionPrice(payDiscountEntity.getDeductionPrice())
                    .payPrice(payDiscountEntity.getPayPrice())
                    .targetCount(payActivityEntity.getTargetCount())
                    .completeCount(0)
                    .lockCount(1)
                    .build();
            groupBuyOrderDao.insert(groupBuyOrder);
        } else{
            int updateAddLockCount = groupBuyOrderDao.updateAddLockCount(teamId);
            if(1!=updateAddLockCount){
                throw new AppException(ResponseCode.E0005);
            }

        }

        String orderId = RandomStringUtils.randomNumeric(12);

        GroupBuyOrderList groupBuyOrderListReq = GroupBuyOrderList.builder()
                .userId(userEntity.getUserId())
                .teamId(teamId)
                .orderId(orderId)
                .activityId(payActivityEntity.getActivityId())
                .startTime(payActivityEntity.getStartTime())
                .endTime(payActivityEntity.getEndTime())
                .goodsId(payDiscountEntity.getGoodsId())
                .source(payDiscountEntity.getSource())
                .channel(payDiscountEntity.getChannel())
                .originalPrice(payDiscountEntity.getOriginalPrice())
                .deductionPrice(payDiscountEntity.getDeductionPrice())
                .status(TradeOrderStatusEnumVO.CREATE.getCode())
                .outTradeNo(payDiscountEntity.getOutTradeNo())
                .bizId(payActivityEntity.getActivityId() + Constants.UNDERLINE + userEntity.getUserId()+Constants.UNDERLINE + (userTakeOrderCount+1))
                .build();

        try{
            groupBuyOrderListDao.insert(groupBuyOrderListReq);
        }catch(DuplicateKeyException e){
            throw new AppException(ResponseCode.E0005);
        }


        return MarketPayOrderEntity.builder()
                .orderId(orderId)
                .deductionPrice(payDiscountEntity.getDeductionPrice())
                .tradeOrderStatusEnumVO(TradeOrderStatusEnumVO.CREATE)
                .build();
    }

    @Override
    public Integer queryOrderCountByActivityId(Long activityId, String userId) {

        GroupBuyOrderList groupBuyOrderListReq = new GroupBuyOrderList();
        groupBuyOrderListReq.setActivityId(activityId);
        groupBuyOrderListReq.setUserId(userId);

        return groupBuyOrderListDao.queryOrderCountByActivityId(groupBuyOrderListReq);


    }

    @Override
    public GroupBuyActivityEntity queryGroupBuyActivityByActivityId(Long activityId) {
        GroupBuyActivity groupBuyActivity = groupBuyActivityDao.queryOrderCountByActivityId(activityId);

        return GroupBuyActivityEntity.builder()
                .activityId(groupBuyActivity.getActivityId())
                .activityName(groupBuyActivity.getActivityName())
                .discountId(groupBuyActivity.getDiscountId())
                .groupType(groupBuyActivity.getGroupType())
                .takeLimitCount(groupBuyActivity.getTakeLimitCount())
                .target(groupBuyActivity.getTarget())
                .validTime(groupBuyActivity.getValidTime())
                .status(ActivityStatusEnumVO.valueOf(groupBuyActivity.getStatus()))
                .startTime(groupBuyActivity.getStartTime())
                .endTime(groupBuyActivity.getEndTime())
                .tagId(groupBuyActivity.getTagId())
                .tagScope(groupBuyActivity.getTagScope())
                .build();

    }
}
