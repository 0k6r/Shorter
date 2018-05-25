package com.oku6er.shorter.controllers

import com.oku6er.shorter.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Add controller class.
 * */
@Controller
@RequestMapping("add")
class AddController {

    @Autowired
    lateinit var service: KeyMapperService

    @RequestMapping(method = [(RequestMethod.POST)])
    @ResponseBody
    fun add(@RequestBody request: AddRequest) =
            ResponseEntity.ok(AddResponse(request.link, service.add(request.link)))

    data class AddRequest(val link: String)
    data class AddResponse(val link: String, val key: String)
}
