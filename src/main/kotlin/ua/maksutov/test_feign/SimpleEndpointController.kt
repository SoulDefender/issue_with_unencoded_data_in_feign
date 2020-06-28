package ua.maksutov.test_feign

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.NotEmpty

@RestController
@RequestMapping("/simpleEndpoint", produces = [MediaType.APPLICATION_JSON_VALUE])
class SimpleEndpointController() {

    private val logger = LoggerFactory.getLogger(SimpleEndpointController::class.java)

    @GetMapping
    fun getObject(@RequestParam test: Boolean, @RequestParam @NotEmpty myValue: String): SimpleObject {
        logger.debug("test=${test} and value=${myValue}")
        return SimpleObject("Simple")
    }

}