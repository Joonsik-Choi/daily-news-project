package com.daily.dailynews.entity

import com.daily.dailynews.dto.NewsRequest
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
) {
    fun update(request: NewsRequest) {
        this.title = request.title
        this.content = request.content
        this.link = request.link
        this.shortSummary = request.shortSummary
        this.longSummary = request.longSummary
        this.category = request.category
        this.pubAt = request.pubAt
    }
}
