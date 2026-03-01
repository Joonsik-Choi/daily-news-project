package com.daily.dailynews

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DailyNewsApplication

fun main(args: Array<String>) {
    runApplication<DailyNewsApplication>(*args)
}
