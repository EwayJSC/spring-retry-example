package com.huantt.springretry.conf

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.retry.RetryCallback
import org.springframework.retry.RetryContext
import org.springframework.retry.listener.RetryListenerSupport

/**
 * @author huantt on 2019-07-27
 */
@CompileStatic
@Slf4j
class MyRetryListener extends RetryListenerSupport {

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        log.warn("Failsafe retrying... \nMethod: {} \nException: {}\nRetrying times: {}",
                context.getAttribute("context.name"),
                throwable.toString(),
                context.getRetryCount(),
                throwable)
        super.onError(context, callback, throwable)
    }
}
