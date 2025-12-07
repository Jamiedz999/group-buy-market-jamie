package com.jamie.infrastructure.dcc;

import com.jamie.types.annotations.DCCValue;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Jamie
 * @date: 06/12/2025 16:15
 */

@Service
public class DCCService {

    @DCCValue("downgradeSwitch:0")
    private String downgradeSwitch;


    @DCCValue("cutRange:100")
    private String cutRange;


    public boolean isDowngradeSwitch() {
        return "1".equals(downgradeSwitch);
    }




    public boolean isCutRange(String userId) {
        // 计算哈希码的绝对值
        int hashCode = Math.abs(userId.hashCode());

        // 获取最后两位
        int lastTwoDigits = hashCode % 100;
        System.out.println("cutRange");
        // 判断是否在切量范围内
        if (lastTwoDigits <= Integer.parseInt(cutRange)) {
            return true;
        }

        return false;
    }


}
