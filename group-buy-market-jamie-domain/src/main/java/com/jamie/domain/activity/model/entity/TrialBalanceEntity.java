package com.jamie.domain.activity.model.entity;

import com.jamie.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 10:04
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrialBalanceEntity{
    private String goodsId;
    private String goodsName;
    private BigDecimal originalPrice;
    private BigDecimal deductionPrice;
    private Integer targetCount;
    private Date startTime;
    private Date endTime;
    private Boolean isVisible;
    private Boolean isEnable;
    private GroupBuyActivityDiscountVO groupBuyActivityDiscountVO;
}
