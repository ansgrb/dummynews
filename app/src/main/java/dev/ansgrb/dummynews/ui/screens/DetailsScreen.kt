package dev.ansgrb.dummynews.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.ansgrb.dummynews.R
import dev.ansgrb.dummynews.model.NewsData

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
    navController: NavController,
    newsData: NewsData,
    scrollState: ScrollState
) {
    DetailsScreenContent(
        newsData = newsData,
        scrollState = scrollState,
//        contentPadding = PaddingValues(0.dp)
    )
}

@Composable
fun DetailsScreenContent(
    newsData: NewsData,
    scrollState: ScrollState,
//    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    DetailsTopAppBar()
    Column(
        modifier = Modifier
//            .padding(contentPadding)
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = newsData.image),
            contentDescription = null
        )
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
        Text(
            text = newsData.title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = newsData.description,
                modifier = Modifier.padding(top = 16.dp)
        )
    }

}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DetailsTopAppBar(onBackPressed: () -> Unit = {}, navController: NavController) {
//    CenterAlignedTopAppBar(
//        modifier = Modifier.padding(0.dp),
//        title = { Text("Details Screen") },
//        navigationIcon = {
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(
//                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                    contentDescription = "Back"
//                )
//            }
//        }
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopAppBar(){
    val scrollMagic = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                "Title",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {/* do somethin' */}
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        scrollBehavior = scrollMagic
    )
//    Scaffold(
//        modifier = Modifier.nestedScroll(scrollMagic.nestedScrollConnection),
//        topBar = {
//
//        },
//        content = {}
//    )
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

@Preview(showBackground = true)
@Composable
fun DetailsTopAppBarPreview(){
    DetailsTopAppBar()
}