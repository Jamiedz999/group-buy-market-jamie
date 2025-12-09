package com.jamie.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 03/12/2025 10:03
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarketProductEntity {

  private Long activityId;
  private String userId;
  private String goodsId;
  private String source;
  private String channel;

}
