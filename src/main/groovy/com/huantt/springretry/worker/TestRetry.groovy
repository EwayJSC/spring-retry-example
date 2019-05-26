package com.huantt.springretry.worker

import com.huantt.springretry.service.TestRetryService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

/**
 * @author huantt on 2019-05-26
 */
@CompileStatic
@Component
class TestRetry {

    @Autowired
    TestRetryService service

    @Scheduled(fixedRate = 9999999999)
    void run() {
        service.doSomethingWithCare("Passed variable")
    }
}
