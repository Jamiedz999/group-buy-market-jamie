package com.jamie.domain.trade.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 16:46
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private String userId;
}
