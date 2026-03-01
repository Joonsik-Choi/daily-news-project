package com.daily.dailynews.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "news_origin")
class NewsOrigin(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "article_id", unique = true)
    val articleId: Long,

    var title: String? = null,

    @Column(columnDefinition = "TEXT")
    var body: String? = null,

    @Column(columnDefinition = "TEXT")
    var summary: String? = null,

    @Column(name = "article_url")
    var articleUrl: String? = null,

    var writers: String? = null,

    @Column(name = "main_category")
    var mainCategory: String? = null,

    @Column(name = "categories", columnDefinition = "TEXT")
    var categories: String? = null,

    @Column(name = "images", columnDefinition = "TEXT")
    var images: String? = null,

    @Column(name = "like_count")
    var likeCount: Int = 0,

    @Column(name = "reply_count")
    var replyCount: Int = 0,

    @Column(name = "reg_dt")
    var regDt: LocalDateTime? = null,

    @Column(name = "service_daytime")
    var serviceDatetime: LocalDateTime? = null,

    var lang: String? = null,
)