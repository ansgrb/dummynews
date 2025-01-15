package dev.ansgrb.dummynews.model

import dev.ansgrb.dummynews.R

data class NewsData(
    val id: Int,
    val author: String,
    val title: String,
    val description: String,
    val image: Int = R.drawable.brnews,
    val publishedAt: String
) {


}