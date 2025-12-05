package com.jamie.domain.activity.service.discount.impl;

import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.jamie.domain.activity.service.discount.AbstractDiscountCalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 04/12/2025 21:42
 */
@Slf4j
@Service("ZK")
public class ZKCalculateService extends AbstractDiscountCalculateService {
    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {

        String marketExpr = groupBuyDiscount.getMarketExpr();

        BigDecimal deductionPrice = originalPrice.multiply(new BigDecimal(marketExpr));

        if (deductionPrice.compareTo(BigDecimal.ZERO) <=0){
            return new BigDecimal("0.01");
        }


        return deductionPrice;
    }
}





