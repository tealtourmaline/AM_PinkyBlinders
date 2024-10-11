package co.edu.upb.pinkyblinders.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.upb.pinkyblinders.ui.RegisterScreen
import co.edu.upb.pinkyblinders.ui.SplashScreen
import co.edu.upb.pinkyblinders.ui.theme.ConfigScreen
import co.edu.upb.pinkyblinders.ui.theme.EntryDetailScreen
import co.edu.upb.pinkyblinders.ui.theme.LoginScreen
import co.edu.upb.pinkyblinders.ui.theme.NewEntryScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route){
        composable(route = AppScreens.SplashScreen.route){
            SplashScreen()
        }
        composable(route = AppScreens.RegisterScreen.route){
            RegisterScreen()
        }
        composable(route = AppScreens.NewEntryScreen.route){
            NewEntryScreen()
        }
        composable(route = AppScreens.MainScreen.route){
            LoginScreen()
        }
        composable(route = AppScreens.LoginScreen.route){
            LoginScreen()
        }
        composable(route = AppScreens.EntryDetailScreen.route){
            EntryDetailScreen(null, null, null)
        }
        composable(route = AppScreens.CreditsScreen.route){
            Credits()
        }
        composable(route = AppScreens.ConfigScreen.route){
            ConfigScreen()
    }
}