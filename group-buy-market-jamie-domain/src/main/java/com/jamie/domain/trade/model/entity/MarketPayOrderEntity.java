package com.jamie.domain.trade.model.entity;

import com.jamie.domain.trade.model.valobj.TradeOrderStatusEnumVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 16:51
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarketPayOrderEntity {

    private String orderId;

    private BigDecimal deductionPrice;

    private TradeOrderStatusEnumVO tradeOrderStatusEnumVO;

}
