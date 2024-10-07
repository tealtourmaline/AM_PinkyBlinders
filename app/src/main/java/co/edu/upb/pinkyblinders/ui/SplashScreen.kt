package co.edu.upb.pinkyblinders.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import co.edu.upb.pinkyblinders.R

@Composable
fun SplashScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFC4EB))
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Splash",
            modifier = Modifier.fillMaxSize()
        )
    }
}



@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen()
}