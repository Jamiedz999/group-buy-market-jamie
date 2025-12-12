package com.jamie.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Jamie
 * @date: 11/12/2025 14:53
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ActivityStatusEnumVO {

    CREATE(0,"create"),
    EFFECTIVE(1,"effect"),
    OVERDUE(2,"outdated"),
    ABANDONED(3,"abandoned"),
    ;



    private Integer code;
    private String info;

    public static ActivityStatusEnumVO valueOf(Integer code){

        switch (code) {
            case 0:
                return CREATE;
            case 1:
                return EFFECTIVE;
            case 2:
                return OVERDUE;
            case 3:
                return ABANDONED;
        }
        throw new RuntimeException("error code not exist");

    }
}
