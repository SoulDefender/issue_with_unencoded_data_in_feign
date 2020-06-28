package ua.maksutov.test_feign

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.env.Environment

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
    classes = [TestFeignApplication::class])
@AutoConfigureMockMvc
class TestControllerTestWithBrokenData {

    @Autowired
    private lateinit var environment: Environment
    @Autowired
    private val restTemplate: TestRestTemplate? = null
    private var port: String? = null

    @BeforeEach
    fun setUp() {
        port = environment.getProperty("server.port");
    }

    @Test
    fun sampleRequestShouldReturnError() {
        assertThat(restTemplate!!.getForObject("http://localhost:$port?encoded=false",
            String::class.java)).contains("name is required.")
    }

    @Test
    fun sampleRequestShouldReturnSampleObject() {
        assertThat(restTemplate!!.getForObject("http://localhost:$port?encoded=true",
            String::class.java)).contains("Simple")
    }
}