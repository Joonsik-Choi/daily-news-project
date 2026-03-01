package com.daily.dailynews.repository

import com.daily.dailynews.entity.News
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface NewsRepository : JpaRepository<News, Long> {
    fun findByCategoryAndPubAtBetween(category: String, startAt: LocalDateTime, endAt: LocalDateTime): List<News>
    fun findByCategory(category: String): List<News>
    fun findByPubAtBetween(startAt: LocalDateTime, endAt: LocalDateTime): List<News>
}
