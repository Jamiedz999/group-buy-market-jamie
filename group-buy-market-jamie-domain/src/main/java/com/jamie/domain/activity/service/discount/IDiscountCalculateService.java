package com.jamie.domain.activity.service.discount;

import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 04/12/2025 21:07
 */
public interface IDiscountCalculateService{

    BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

}
