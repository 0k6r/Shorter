package com.oku6er.shorter.service

import com.oku6er.shorter.model.Link
import com.oku6er.shorter.model.repositories.LinkRepository
import com.oku6er.shorter.whenever
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

/**
 * Tests for {@link DefaultKeyMapperService} class
 * */
class DefaultKeyMapperServiceTest {

    @InjectMocks
    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY: String = "abcdefg"
    private val LINK_A: String = "https://habr.com"
    private val LINK_B: String = "https://google.com"
    private val KEY_A: String = "abc"
    private val KEY_B: String = "cde"
    private val ID_A: Long = 10000000L
    private val ID_B: Long = 10000001L
    private val LINK_OBJ_A: Link = Link(LINK_A, ID_A)
    private val LINK_OBJ_B: Link = Link(LINK_B, ID_B)

    @Mock
    lateinit var converter: KeyConverterService

    @Mock
    lateinit var repo: LinkRepository


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        whenever(converter.keyToId(KEY_A)).thenReturn(ID_A)
        whenever(converter.idToKey(ID_A)).thenReturn(KEY_A)
        whenever(converter.keyToId(KEY_B)).thenReturn(ID_B)
        whenever(converter.idToKey(ID_B)).thenReturn(KEY_B)

        whenever(repo.findById(Mockito.any())).thenReturn(Optional.empty())
        whenever(repo.save(Link(LINK_A))).thenReturn(LINK_OBJ_A)
        whenever(repo.save(Link(LINK_B))).thenReturn(LINK_OBJ_B)
        whenever(repo.findById(ID_A)).thenReturn(Optional.of(LINK_OBJ_A))
        whenever(repo.findById(ID_B)).thenReturn(Optional.of(LINK_OBJ_B))
    }

    @Test
    fun clientCanAddLinks() {
        val keyA = service.add(LINK_A)
        assertEquals(KeyMapperService.Get.Link(LINK_A), service.getLink(keyA))
        val keyB = service.add(LINK_B)
        assertEquals(KeyMapperService.Get.Link(LINK_B), service.getLink(keyB))
        assertNotEquals(keyA, keyB)
        println()
    }

    @Test
    fun clientCanNotTakeLinkIfKeyIsNotFoundInService() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }
}