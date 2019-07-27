package com.huantt.springretry

import com.huantt.springretry.service.TestRetryService
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
@Slf4j
class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args)
        TestRetryService service = context.getBean(TestRetryService.class)
        String result = service.doSomethingWithCare("Hello")
        log.info("@Result: {}", result)
    }
}
