package com.huantt.springretry.service

import com.huantt.springretry.exception.MyException
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable
import org.springframework.stereotype.Service

/**
 * @author huantt on 2019-05-26
 */
@CompileStatic
@Service
@Slf4j
class TestRetryService {

    public static int counter = 0

    @Retryable(
            value = [Exception.class],
            maxAttempts = 3,
            backoff = @Backoff(1000L))
    public void doSomethingWithCare(String variable) {
        switch (counter) {
            case 0:
                log.info("#${counter++}")
                throw new MyException()
                break
            case 1:
                log.info("#${counter++}")
                throw new RuntimeException("#2 Error")
                break
            case 2:
                log.info("#${counter++}")
                throw new NullPointerException("#3 Error")
        }
    }

    @Recover
    public void recover(Exception exception, String variable) {
        log.error("Failed to retry\nException: ${exception.class.name}\nVariable: $variable")
    }

}
