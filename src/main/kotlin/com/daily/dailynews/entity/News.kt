package com.daily.dailynews.entity

import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDateTime

@Entity
@Table(name = "news")
class News(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var title: String? = null,
    var content: String? = null,
    var link: String? = null,

    @Column(name = "short_summary")
    var shortSummary: String? = null,

    @Column(name = "long_summary")
    var longSummary: String? = null,

    var category: String? = null,

    @Column(name = "pub_at")
    var pubAt: LocalDateTime? = null,

    @Column(name = "created_at", updatable = false)
    var createdAt: Instant = Instant.now(),
)
