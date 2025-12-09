package com.jamie.domain.trade.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 17:02
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyProgressVO {

    private Integer targetCount;

    private Integer completeCount;
    private Integer lockCount;
}
