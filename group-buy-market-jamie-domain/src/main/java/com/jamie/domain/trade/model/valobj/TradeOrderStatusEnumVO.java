package com.jamie.domain.trade.model.valobj;

import lombok.*;

/**
 * @description:
 * @author: Jamie
 * @date: 07/12/2025 16:55
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TradeOrderStatusEnumVO {

    CREATE(0, "初始创建"),
    COMPLETE(0, "消费完成"),
    CLOSE(0, "超时关单"),
    ;

    private Integer code;
    private String info;

    public static TradeOrderStatusEnumVO valueOf(Integer code){
        switch(code){
            case 0: return CREATE;
            case 1: return COMPLETE;
            case 2: return CLOSE;
        }
        return CREATE;
    }

}
