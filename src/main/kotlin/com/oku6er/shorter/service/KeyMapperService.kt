package com.oku6er.shorter.service

/**
 * Interface for mapping keys.
 * */
interface KeyMapperService {

    interface Get {
        data class Link(val link: String): Get
        data class NotFound(val key: String): Get
    }

    fun getLink(key: String): Get
    fun add(link: String): String

}
