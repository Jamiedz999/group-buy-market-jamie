package com.jamie.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 16:46
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SCSkuActivityVO {


    private Long activityId;

    /** 来源 */
    private String source;
    /** 渠道 */
    private String channel;
    /** 商品ID */
    private String goodsId;

}
