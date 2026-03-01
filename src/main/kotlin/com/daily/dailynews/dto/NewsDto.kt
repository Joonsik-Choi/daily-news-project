package com.daily.dailynews.dto

import com.daily.dailynews.entity.News
import java.time.Instant
import java.time.LocalDateTime

data class NewsRequest(
    val title: String? = null,
    val content: String? = null,
    val link: String? = null,
    val shortSummary: String? = null,
    val longSummary: String? = null,
    val category: String? = null,
    val pubAt: LocalDateTime? = null,
) {
    fun toEntity() = News(
        title = title,
        content = content,
        link = link,
        shortSummary = shortSummary,
        longSummary = longSummary,
        category = category,
        pubAt = pubAt,
    )
}

data class NewsResponse(
    val id: Long,
    val title: String?,
    val content: String?,
    val link: String?,
    val shortSummary: String?,
    val longSummary: String?,
    val category: String?,
    val pubAt: LocalDateTime?,
    val createdAt: Instant,
) {
    companion object {
        fun from(news: News) = NewsResponse(
            id = news.id,
            title = news.title,
            content = news.content,
            link = news.link,
            shortSummary = news.shortSummary,
            longSummary = news.longSummary,
            category = news.category,
            pubAt = news.pubAt,
            createdAt = news.createdAt,
        )
    }
}
