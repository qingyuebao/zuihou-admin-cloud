package com.github.zuihou.order.config;

import com.github.zuihou.authority.api.LogApi;
import com.github.zuihou.common.config.BaseConfig;
import com.github.zuihou.log.event.SysLogListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zuihou
 * @createTime 2017-12-15 14:42
 */
@Configuration
public class OrderWebConfiguration extends BaseConfig {
    @Value("${zuihou.mysql.biz-database:zuihou_defaults}")
    private String database;

    @Bean
    public SysLogListener sysLogListener(LogApi logApi) {
        return new SysLogListener(this.database, (log) -> logApi.save(log));
    }
}
