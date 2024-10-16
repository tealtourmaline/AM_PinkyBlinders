package co.edu.upb.pinkyblinders.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.clases.UserPreferences
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    val context = LocalContext.current
    val userPreferences = UserPreferences(context)

    LaunchedEffect(Unit){
        delay(2000)

        // Comprueba si ya existe un usuario registrado
        val savedName = userPreferences.getUserName()
        val savedPin = userPreferences.getUserPin()

        if (savedName != null && savedPin != null) {
            navController.navigate("login_screen") {
                popUpTo("splash_screen") {
                    inclusive = true
                }
            }
        } else {
            navController.navigate("register_screen") {
                popUpTo("splash_screen") {
                    inclusive = true
                }
            }
        }
    }

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



/*
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    SplashScreen()
}*/
