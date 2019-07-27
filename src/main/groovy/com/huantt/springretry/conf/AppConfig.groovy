package com.huantt.springretry.conf

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.RetryListener
import org.springframework.retry.annotation.EnableRetry

/**
 * @author huantt on 2019-05-26
 */
@Configuration
@EnableRetry
@CompileStatic
@Slf4j
class AppConfig {

    @Bean
    public List<RetryListener> retryListeners() {
        return Collections.singletonList(new MyRetryListener())
    }
}
