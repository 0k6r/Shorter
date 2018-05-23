package com.oku6er.shorter.service

import org.junit.Test
import org.junit.Assert.*

/**
 * Tests for DefaultKeyMapperService class
 * */
class DefaultKeyMapperServiceTest {

    val service: KeyMapperService = DefaultKeyMapperService()

    @Test
    fun clientCanAddNewKeyWithLink() {
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey() {
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(Key), service.getLink(KEY))
    }
}