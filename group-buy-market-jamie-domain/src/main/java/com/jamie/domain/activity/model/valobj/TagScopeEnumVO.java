package com.jamie.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 05/12/2025 18:33
 */


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TagScopeEnumVO {

    VISIBLE(true, false, "是否能看到拼团"),
    ENABLE(true, false,"是否能参与拼团"),
    ;

    private Boolean allow;
    private Boolean refuse;
    private String desc;


}
