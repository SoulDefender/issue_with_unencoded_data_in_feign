package ua.maksutov.test_feign

import org.apache.catalina.util.URLEncoder
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
class TestController(val justClient: JustClient) {

    private val logger = LoggerFactory.getLogger(TestController::class.java)
    private val urlEncoder = URLEncoder()

    @GetMapping
    fun getObject(@RequestParam encoded: Boolean): SimpleObject {
        val dataWithAmpersands = "someData&&SomeData"
        val dataForSimpleEndpoint = if (encoded) {
            urlEncoder.encode(dataWithAmpersands, Charsets.UTF_8)
        } else {
            dataWithAmpersands
        }
        try {
            return justClient.getSimpleObject(dataForSimpleEndpoint)
        } catch (e: Exception) {
            logger.error(e.message, e)
            throw e
        }
    }

}