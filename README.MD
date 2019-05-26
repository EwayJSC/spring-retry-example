# Dependencies
    implementation 'org.springframework.retry:spring-retry'
    implementation 'org.springframework:spring-aspects'
    

# Implementation
See how to implement spring-retry in [TestRetryService](src/main/groovy/com/huantt/springretry/service/TestRetryService.groovy)

```Groovy
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
```

