package com.oku6er.shorter.model.repositories

import org.springframework.data.repository.Repository
import com.oku6er.shorter.model.Link
import java.util.*

/**
 * Repository to manage {@link Link} instances.
 *
 * @author Konstantin Petrov
 * @license MIT
 * */
interface LinkRepository : Repository<Link, Long> {
    fun findOne(id: Long?): Optional<Link>
    fun save(link: Link): Link
    fun findAll(): List<Link>
}