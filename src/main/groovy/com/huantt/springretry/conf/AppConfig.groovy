package com.huantt.springretry.conf

import groovy.transform.CompileStatic
import org.springframework.context.annotation.Configuration
import org.springframework.retry.annotation.EnableRetry
import org.springframework.scheduling.annotation.EnableScheduling

/**
 * @author huantt on 2019-05-26
 */
@CompileStatic
@Configuration
@EnableScheduling
@EnableRetry
class AppConfig {

}
