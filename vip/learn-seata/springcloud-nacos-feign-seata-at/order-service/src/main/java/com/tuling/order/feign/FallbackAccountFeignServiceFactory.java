package com.tuling.order.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Fox
 */
@Component
@Slf4j
public class FallbackAccountFeignServiceFactory implements FallbackFactory<AccountFeignService> {
    @Override
    public AccountFeignService create(Throwable throwable) {

        return new AccountFeignService() {
            @Override
            public Boolean debit(String userId, int money) {
                log.info("账户服务异常降级了");
                // 解决 feign整合sentinel降级导致Seata失效的处理  此方案不可取
                //
//                if(!StringUtils.isEmpty(RootContext.getXID())){
//                    //通过xid获取GlobalTransaction调用rollback回滚
                //  可以让库存服务回滚  能解决问题吗？  绝对不能用
//                    GlobalTransactionContext.reload(RootContext.getXID()).rollback();
//                }
                return false;
            }
        };
    }
}