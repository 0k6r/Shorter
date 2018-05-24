package com.oku6er.shorter.controllers

import com.oku6er.shorter.ShorterApplication
import com.oku6er.shorter.service.KeyMapperService
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

/**
 * Tests for RedirectController class
 * */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest(classes = [(ShorterApplication::class)])
@WebAppConfiguration
@TestPropertySource(locations = ["classpath:repositories-test.properties"])
class RedirectControllerTest {

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext

    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var service: KeyMapperService

    @Autowired
    @InjectMocks
    lateinit var controller: RedirectController

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build()

        Mockito.`when`(service.getLink(PATH)).thenReturn(KeyMapperService.Get.Link(HEADER_VALUE))
        Mockito.`when`(service.getLink(BAD_PATH)).thenReturn(KeyMapperService.Get.NotFound(BAD_PATH))
    }

    private val PATH: String = "abcdefg"
    private val REDIRECT_STATUS: Int = 302
    private val HEADER_NAME: String = "Location"
    private val HEADER_VALUE: String = "https://habr.com"

    @Test
    fun controllerMustRedirectUsWhenRequestIsSuccessful() {
        mockMvc.perform(MockMvcRequestBuilders.get("/$PATH"))
                .andExpect(MockMvcResultMatchers.status().`is`(REDIRECT_STATUS))
                .andExpect(MockMvcResultMatchers.header().string(HEADER_NAME, HEADER_VALUE))
    }

    private val BAD_PATH: String = "asdfghj"
    private val NOT_FOUND: Int = 404

    @Test
    fun controllerMustReturn404IfBadKey() {
        mockMvc.perform(MockMvcRequestBuilders.get("/$BAD_PATH"))
                .andExpect(MockMvcResultMatchers.status().`is`(NOT_FOUND))
    }
}