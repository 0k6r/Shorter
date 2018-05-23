package com.oku6er.shorter.service

import junit.framework.Assert.assertEquals
import org.junit.Test
import java.util.*

/**
 * Tests for DefaultKeyConverterService class.
 * */
class DefaultKeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays() {
        val random = Random()
        for (i in 0..1000) {
            val initialId = Math.abs(random.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToId(key)
            assertEquals(initialId, id)
        }
    }
}