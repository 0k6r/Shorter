package com.oku6er.shorter

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [(ShorterApplication::class)])
@WebAppConfiguration
@TestPropertySource(locations = ["classpath:repositories-test.properties"])
class ShorterApplicationTests {

	@Test
	fun contextLoads() {
	}

}
