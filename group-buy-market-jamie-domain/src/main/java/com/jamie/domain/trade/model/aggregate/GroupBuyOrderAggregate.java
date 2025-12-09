package com.jamie.domain.trade.model.aggregate;

import com.jamie.domain.trade.model.entity.PayActivityEntity;
import com.jamie.domain.trade.model.entity.PayDiscountEntity;
import com.jamie.domain.trade.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 17:00
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyOrderAggregate {

    private UserEntity userEntity;

    private PayActivityEntity payActivityEntity;

    private PayDiscountEntity payDiscountEntity;

}
