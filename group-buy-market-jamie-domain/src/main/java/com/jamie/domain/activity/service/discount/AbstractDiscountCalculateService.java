package com.jamie.domain.activity.service.discount;

import com.jamie.domain.activity.adapter.repository.IActivityRepository;
import com.jamie.domain.activity.model.valobj.DiscountTypeEnum;
import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 04/12/2025 21:30
 */
@Slf4j
public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService{

    @Resource
    protected IActivityRepository repository;

    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        if (DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())){
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange) {
                log.info("discount calculation 拦截 userId:{}", userId);
                return originalPrice;
            }
        }

        return doCalculate(originalPrice, groupBuyDiscount);

    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);


    private boolean filterTagId(String userId, String tagId) {

        return repository.isTagCrowRange(tagId, userId);

    }
}
