package dev.ansgrb.dummynews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowInsetsControllerCompat
import dev.ansgrb.dummynews.ui.NewsApp
import dev.ansgrb.dummynews.ui.theme.DummynewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DummynewsTheme {
                val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
                windowInsetsController.isAppearanceLightStatusBars = true // For light status bar
                windowInsetsController.isAppearanceLightNavigationBars = true
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.systemBars.asPaddingValues())

                ) { innerPadding ->
                    NewsApp(paddingValues = innerPadding)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    DummynewsTheme {
        NewsApp(paddingValues = PaddingValues())
    }
}