package com.oku6er.shorter.service

import org.springframework.stereotype.Component

/**
 * Class for implementation interface KeyConverterService.
 * */
@Component
class DefaultKeyConverterService : KeyConverterService {

    val chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890-_".toCharArray()
    val charToLong = (0 until chars.size)
            .map { i -> Pair(chars[i], i.toLong()) }
            .toMap()

    override fun idToKey(id: Long): String {
        var n = id
        val builder = StringBuilder()
        while (n != 0L) {
            builder.append(chars[((n % chars.size).toInt())])
            n /= chars.size
        }
        return builder.reverse().toString()
    }

    override fun keyToId(key: String) = key
            .map { i -> charToLong[i]!! }
            .fold(0L, { a, b -> a * chars.size + b })

}
