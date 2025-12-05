package com.jamie.domain.tag.model.entity;

import lombok.*;

import java.util.Date;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 11:42
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrowdTagsJobEntity {


    /** 标签类型（参与量、消费金额） */
    private Integer tagType;
    /** 标签规则（限定类型 N次） */
    private String tagRule;
    /** 统计数据，开始时间 */
    private Date statStartTime;
    /** 统计数据，结束时间 */
    private Date statEndTime;

}
