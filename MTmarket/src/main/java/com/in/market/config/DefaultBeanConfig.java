package com.in.market.config;

import com.in.market.commons.cache.strategycache.StrategyCache;
import com.in.market.commons.cache.strategycache.impl.DefaultStrategyCache;
import com.in.market.commons.cache.typecache.TypeCache;
import com.in.market.commons.cache.typecache.impl.DefaultTypeCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author TheSevenSKy
 */
@Configuration
public class DefaultBeanConfig {

    @Bean
    public TypeCache initTypeCache() {
        return new DefaultTypeCache();
    }

    @Bean
    public StrategyCache initStrategyCache() {
        return new DefaultStrategyCache();
    }
}
