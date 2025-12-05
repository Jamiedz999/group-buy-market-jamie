package com.jamie.domain.activity.service.discount;

import com.jamie.domain.activity.model.valobj.DiscountTypeEnum;
import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 04/12/2025 21:30
 */
public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService{
    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        if (DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())){
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange) return originalPrice;
        }

        return doCalculate(originalPrice, groupBuyDiscount);

    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);


    private boolean filterTagId(String userId, String tagId) {

        return true;

    }
}
