package com.jamie.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 11/12/2025 14:35
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeRuleFilterBackEntity {

    private Integer userTakeOrderCount;

}
