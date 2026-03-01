package com.daily.dailynews.repository

import com.daily.dailynews.entity.News
import org.springframework.data.jpa.repository.JpaRepository

interface NewsRepository : JpaRepository<News, Long>
