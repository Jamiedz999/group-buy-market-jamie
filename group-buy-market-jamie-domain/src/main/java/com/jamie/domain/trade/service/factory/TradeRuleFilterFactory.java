package com.jamie.domain.trade.service.factory;

import com.jamie.domain.trade.model.entity.GroupBuyActivityEntity;
import com.jamie.domain.trade.model.entity.TradeRuleCommandEntity;
import com.jamie.domain.trade.model.entity.TradeRuleFilterBackEntity;
import com.jamie.domain.trade.service.filter.ActivityUsabilityRuleFilter;
import com.jamie.domain.trade.service.filter.UserTakeLimitRuleFilter;
import com.jamie.types.design.framework.link.model2.LinkArmory;
import com.jamie.types.design.framework.link.model2.chain.BusinessLinkedList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Jamie
 * @date: 11/12/2025 14:37
 */

@Slf4j
@Service
public class TradeRuleFilterFactory {

    @Bean("tradeRuleFilter")
    public BusinessLinkedList<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> tradeRuleFilter(ActivityUsabilityRuleFilter activityUsabilityRuleFilter, UserTakeLimitRuleFilter userTakeLimitRuleFilter){

        LinkArmory<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> linkArmory = new LinkArmory< TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity>("trade rule filter list", activityUsabilityRuleFilter, userTakeLimitRuleFilter);

        return linkArmory.getLogicLink();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext{

        private GroupBuyActivityEntity groupBuyActivity;

    }

}
