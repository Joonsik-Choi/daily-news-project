package com.daily.dailynews.controller

import com.daily.dailynews.dto.NewsRequest
import com.daily.dailynews.dto.NewsResponse
import com.daily.dailynews.service.NewsService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/news")
class NewsController(
    private val newsService: NewsService,
) {
    @GetMapping
    fun findAll(): List<NewsResponse> = newsService.findAll()

    @GetMapping("/search")
    fun search(
        @RequestParam(required = false) category: String?,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) startAt: LocalDateTime?,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) endAt: LocalDateTime?,
    ): List<NewsResponse> = newsService.search(category, startAt, endAt)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): NewsResponse = newsService.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: NewsRequest): NewsResponse = newsService.create(request)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: NewsRequest): NewsResponse =
        newsService.update(id, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) = newsService.delete(id)
}
