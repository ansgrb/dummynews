package dev.ansgrb.dummynews.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.ansgrb.dummynews.MockData
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
                TopNewsItem(newsData = newsData)
            }
        }
    }
}

@Composable
fun TopNewsItem(newsData: NewsData){
    Box(
        modifier = Modifier
            .height(200.dp)
            .padding(8.dp)
    ){
        Image(
            painter = painterResource(id = newsData.image),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = newsData.publishedAt,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(
                modifier = Modifier.height(90.dp)
            )
            Text(
                text = newsData.title,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
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