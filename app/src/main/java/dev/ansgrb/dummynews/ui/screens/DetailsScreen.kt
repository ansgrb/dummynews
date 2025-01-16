package dev.ansgrb.dummynews.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.ansgrb.dummynews.R
import dev.ansgrb.dummynews.model.NewsData

@Composable
fun DetailsScreen(navController: NavController, newsData: NewsData, scrollState: ScrollState){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Text(
            text = "Details Screen",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
        )
        Image(painter = painterResource(id = newsData.image), contentDescription = "")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconInfo(
                icon = Icons.Default.Edit,
                info = newsData.author,
                contentDescription = "Author"
            )
            IconInfo(
                icon = Icons.Default.DateRange,
                info = newsData.publishedAt,
                contentDescription = "Published Date"
            )
        }
        Text(text = newsData.title, fontWeight = FontWeight.Bold)
        Text(text = newsData.description, modifier = Modifier.padding(top = 16.dp))
    }
}

@Composable
fun IconInfo(icon: ImageVector, info: String, contentDescription: String){
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            icon,
            contentDescription = contentDescription,
            tint = colorResource(id = R.color.purple_700),
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = info)
    }

}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    DetailsScreen(rememberNavController(), NewsData(
        id = 1,
        author = "John Doe",
        title = "Title 1",
        description = "Description 1",
        publishedAt = "2021-09-01"
    ), ScrollState(0))
}