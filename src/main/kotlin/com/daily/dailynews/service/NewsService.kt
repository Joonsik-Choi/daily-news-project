package com.daily.dailynews.service

import com.daily.dailynews.dto.NewsRequest
import com.daily.dailynews.dto.NewsResponse
import com.daily.dailynews.repository.NewsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class NewsService(
    private val newsRepository: NewsRepository,
) {
    fun findAll(): List<NewsResponse> =
        newsRepository.findAll().map { NewsResponse.from(it) }

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
        news.title = request.title
        news.content = request.content
        news.link = request.link
        news.shortSummary = request.shortSummary
        news.longSummary = request.longSummary
        news.category = request.category
        news.pubAt = request.pubAt
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
