package com.jamie.domain.activity.service.discount.impl;

import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.jamie.domain.activity.service.discount.AbstractDiscountCalculateService;
import com.jamie.types.common.Constants;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 04/12/2025 21:36
 */

@Service("MJ")
public class MJCalculateService  extends AbstractDiscountCalculateService {


    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {


        String marketExpr = groupBuyDiscount.getMarketExpr();

        String[] split = marketExpr.split(Constants.SPLIT);

        BigDecimal x = new BigDecimal(split[0]);
        BigDecimal y = new BigDecimal(split[1]);

        if( originalPrice.compareTo(x)<0){
            return originalPrice;
        }

        BigDecimal deductionPrice = originalPrice.subtract(y);

        if (deductionPrice.compareTo(BigDecimal.ZERO) <=0){
            return new BigDecimal("0.01");
        }

        return deductionPrice;
    }
}
