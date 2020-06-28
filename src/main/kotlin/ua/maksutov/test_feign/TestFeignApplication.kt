package ua.maksutov.test_feign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@EnableFeignClients(basePackages = ["ua.maksutov.test_feign"])
@SpringBootApplication
class TestFeignApplication {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

}

fun main(args: Array<String>) {
    runApplication<TestFeignApplication>(*args)
}
