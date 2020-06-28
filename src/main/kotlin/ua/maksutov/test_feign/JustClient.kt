package ua.maksutov.test_feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("http://self",url = "http://localhost:8090")
interface JustClient {
    @GetMapping("/simpleEndpoint?test=true")
    fun getSimpleObject(@RequestParam("myValue") value: String): SimpleObject
}