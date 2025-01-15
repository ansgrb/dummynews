package dev.ansgrb.dummynews.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailsScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Details Screen",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
        )
        Button(
            onClick = {
//                navController.navigate("TopNewsScreen")
                navController.popBackStack()
            }
        ) {
            Text("Go to Top News Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    DetailsScreen(rememberNavController())
}