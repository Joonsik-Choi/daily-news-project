package com.daily.dailynews.service

import com.daily.dailynews.dto.NewsRequest
import com.daily.dailynews.dto.NewsResponse
import com.daily.dailynews.repository.NewsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional(readOnly = true)
class NewsService(
    private val newsRepository: NewsRepository,
) {
    fun findAll(): List<NewsResponse> =
        newsRepository.findAll().map { NewsResponse.from(it) }

    fun search(category: String?, startAt: LocalDateTime?, endAt: LocalDateTime?): List<NewsResponse> {
        val newsList = when {
            category != null && startAt != null && endAt != null ->
                newsRepository.findByCategoryAndPubAtBetween(category, startAt, endAt)
            category != null ->
                newsRepository.findByCategory(category)
            startAt != null && endAt != null ->
                newsRepository.findByPubAtBetween(startAt, endAt)
            else ->
                newsRepository.findAll()
        }
        return newsList.map { NewsResponse.from(it) }
    }

    fun findById(id: Long): NewsResponse =
        newsRepository.findById(id)
            .map { NewsResponse.from(it) }
            .orElseThrow { NoSuchElementException("News not found: $id") }

    @Transactional
    fun create(request: NewsRequest): NewsResponse {
        val news = newsRepository.save(request.toEntity())
        return NewsResponse.from(news)
    }

    @Transactional
    fun update(id: Long, request: NewsRequest): NewsResponse {
        val news = newsRepository.findById(id)
            .orElseThrow { NoSuchElementException("News not found: $id") }
        news.update(request)
        return NewsResponse.from(news)
    }

    @Transactional
    fun delete(id: Long) {
        if (!newsRepository.existsById(id)) {
            throw NoSuchElementException("News not found: $id")
        }
        newsRepository.deleteById(id)
    }
}
