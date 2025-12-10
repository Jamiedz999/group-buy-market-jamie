package com.jamie.test.types.rule02.logic;

import com.jamie.types.design.framwork.link.model2.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.jamie.test.types.rule02.factory.Rule02TradeRuleFactory;

/**
 * @description:
 * @author: Jamie
 * @date: 09/12/2025 22:12
 */
@Slf4j
@Service
public class RuleLogic202 implements ILogicHandler<String, Rule02TradeRuleFactory.DynamicContext, XxxResponse> {

    public XxxResponse apply(String requestParameter, Rule02TradeRuleFactory.DynamicContext dynamicContext) throws Exception{

        log.info("link model02 RuleLogic202");

        return new XxxResponse("hi 小傅哥！");
    }

}
