package com.oku6er.shorter.service

/**
 * Interface for key converting.
 * */
interface KeyConverterService {
    fun idToKey(id: Long): String
    fun keyToId(key: String): Long
}
