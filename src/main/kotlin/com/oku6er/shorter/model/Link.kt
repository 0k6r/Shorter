package com.oku6er.shorter.model

import javax.persistence.*

/**
 * Link entity class.
 * */
@Entity
@Table(name = "links")
data class Link(
        var text: String = "",
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0L
)