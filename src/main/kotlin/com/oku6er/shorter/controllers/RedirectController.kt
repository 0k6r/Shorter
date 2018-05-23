package com.oku6er.shorter.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletResponse

/**
 * Controller for redirecting
 * */
@Controller
@RequestMapping("/{key}")
class RedirectController {

    @RequestMapping()
    fun redirect(@PathVariable("key") key: String, response: HttpServletResponse) {
        if (key == "abcdefg") {
            response.setHeader(HEADER_NAME, "https://habr.com")
            response.status = 302
        } else {
            response.status = 404
        }

    }

    companion object {
        private val HEADER_NAME = "Location"
    }

}