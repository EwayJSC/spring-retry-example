package com.huantt.springretry.service

import com.huantt.springretry.exception.MyException
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
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

    @Retryable
    public String doSomethingWithCare(String variable) {
        switch (counter) {
            case 0:
                log.debug("#${counter++}")
                throw new MyException()
                break
            case 1:
                log.debug("#${counter++}")
                throw new RuntimeException("#2 Error")
                break
            case 2:
                log.debug("#${counter++}")
                throw new NullPointerException("#3 Error")
        }

        return variable + " completed!"
    }

    @Recover
    public String recover(Exception exception, String variable) {
        log.error("Failed to retry\nPassed Variable: $variable", exception)
        return null
    }

    @Recover
    public String recover(NullPointerException exception, String variable) {
        log.error("Failed to retry NullPointerException\nPassed Variable: $variable", exception)
        return "This value is returned by recover(NullPointerException exception, String variable) method"
    }

}
