package dev.ansgrb.dummynews

import dev.ansgrb.dummynews.model.NewsData

object MockData {
    val topNewsList = listOf<NewsData>(
        NewsData(
            id = 1,
            author = "John Doe",
            title = "Title 1",
            description = "Description 1",
            publishedAt = "2021-09-01"
        ),
        NewsData(
            id = 2,
            image = R.drawable.ass_01,
            author = "Helen Regan",
            title = "Dramatic showdown looms in South Korea as Yoon faces impeachment trial and possible arrest",
            description = "Description 2",
            publishedAt = "2021-09-02"
        ),
        NewsData(
            id = 3,
            image = R.drawable.ass_02,
            author = "Sam Smith",
            title = "How the climate crisis fuels gender inequality",
            description = "Description 3",
            publishedAt = "2021-09-03"
        ),
        NewsData(
            id = 4,
            image = R.drawable.ass_03,
            author = "Andrei Doe",
            title = "Android Jetpack Compose tutorial for beginners",
            description = "Description 4",
            publishedAt = "2021-09-04"
        ),
        NewsData(
            id = 5,
            image = R.drawable.ass_04,
            author = "John Doe",
            title = "Title 5",
            description = "Description 5",
            publishedAt = "2021-09-05"
        ),
        NewsData(
            id = 6,
            image = R.drawable.ass_05,
            author = "Jane Doe",
            title = "Title 6",
            description = "Description 6",
            publishedAt = "2021-09-06"
        ),
        NewsData(
            id = 7,
            author = "John Doe",
            title = "Title 7",
            description = "Description 7",
            publishedAt = "2021-09-07"
        ),
        NewsData(
            id = 8,
            author = "Jane Doe",
            title = "Title 8",
            description = "Description 8",
            publishedAt = "2021-09-08"
        ),
        NewsData(
            id = 9,
            author = "John Doe",
            title = "Title 9",
            description = "Description 9",
            publishedAt = "2021-09-09"
        ),
        NewsData(
            id = 10,
            author = "Jane Doe",
            title = "Title 10",
            description = "Description 10",
            publishedAt = "2021-09-10"
        ),
    )
    fun getNewsById(id: Int?): NewsData{
        return topNewsList.first { it.id == id }
    }
}