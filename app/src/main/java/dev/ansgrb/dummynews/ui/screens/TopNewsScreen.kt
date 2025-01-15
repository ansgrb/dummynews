package dev.ansgrb.dummynews.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.ansgrb.dummynews.MockData
import dev.ansgrb.dummynews.components.TopNewsItem
import dev.ansgrb.dummynews.model.NewsData

@Composable
fun TopNewsScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Top News",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
            )
        LazyColumn(){
            items(MockData.topNewsList){
                newsData ->
                TopNewsItem(newsData = newsData, onNewsClicked = {
                    navController.navigate("DetailsScreen/${newsData.id}")
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopNewsScreenPreview(){
    TopNewsItem(
        newsData = NewsData(
            id = 1,
            author = "John Doe",
            title = "Title 1",
            description = "Description 1",
            publishedAt = "2021-09-01"
        )
    )
}