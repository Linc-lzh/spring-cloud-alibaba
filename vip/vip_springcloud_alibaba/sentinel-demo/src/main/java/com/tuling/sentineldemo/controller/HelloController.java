package com.tuling.sentineldemo.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.tuling.sentineldemo.exception.ExceptionUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class HelloController {

    private static final String RESOURCE_NAME = "HelloWorld";

    @RequestMapping(value = "/hello")
    public String hello() {
        try (Entry entry = SphU.entry(RESOURCE_NAME)) {
            // 被保护的逻辑
            log.info("hello world");
            return "hello world";
        } catch (BlockException ex) {
            // 处理被流控的逻辑
            log.info("blocked!");
            return "被流控了";
        }

    }

    /**
     * 定义流控规则
     */
    @PostConstruct
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置受保护的资源
        rule.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值
        rule.setCount(3);
        rules.add(rule);
        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }


//    @SentinelResource(value = RESOURCE_NAME, blockHandler = "handleException",
//        fallback = "fallbackException")
    @SentinelResource(value = RESOURCE_NAME,
            blockHandler = "handleException",blockHandlerClass = ExceptionUtil.class,
            fallback = "fallbackException",fallbackClass = ExceptionUtil.class)
    @RequestMapping("/hello2")
    public String hello2() {

        int i = 1 / 0;

        return "helloworld ";
    }


    // Block 异常处理函数，参数最后多一个 BlockException，其余与原方法hello2一致.
    public String handleException(BlockException ex){
        return "被流控了";
    }

    // Fallback 异常处理函数，参数与原方法hello2一致或加一个 Throwable 类型的参数.
    public String fallbackException(Throwable t){
        return "被异常降级了";
    }


}