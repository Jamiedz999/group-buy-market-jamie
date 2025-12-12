package com.jamie.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 16:46
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayDiscountEntity {

    private String source;

    private String channel;

    private String goodsId;

    private String goodsName;

    private BigDecimal originalPrice;

    private BigDecimal deductionPrice;

    private BigDecimal payPrice;

    private String outTradeNo;



}
