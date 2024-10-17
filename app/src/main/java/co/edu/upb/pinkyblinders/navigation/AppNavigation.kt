package co.edu.upb.pinkyblinders.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.rememberNavController
import co.edu.upb.pinkyblinders.clases.Entry
import co.edu.upb.pinkyblinders.ui.CreditsScreen
import co.edu.upb.pinkyblinders.ui.MainScreen
import co.edu.upb.pinkyblinders.ui.RegisterScreen
import co.edu.upb.pinkyblinders.ui.SplashScreen
import co.edu.upb.pinkyblinders.ui.theme.ConfigScreen
import co.edu.upb.pinkyblinders.ui.theme.EntryDetailScreen
import co.edu.upb.pinkyblinders.ui.theme.LoginScreen
import co.edu.upb.pinkyblinders.ui.theme.NewEntryScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val entriesList = remember { mutableStateListOf<Entry>() }

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(route = AppScreens.NewEntryScreen.route) {
            NewEntryScreen(navController, entriesList)
        }
        composable(route = AppScreens.MainScreen.route) {
            MainScreen(navController, entriesList)
        }
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.EntryDetailScreen.route + "/{entryId}") { backStackEntry ->
            val entryId = backStackEntry.arguments?.getString("entryId")
            // Busca la entrada correspondiente en la lista usando el entryId
            val entry = entriesList.find { it.id == entryId }
            EntryDetailScreen(
                titulo = entry?.titulo,
                fecha = entry?.fechaCreacion,
                descripcion = entry?.descripcion,
                navController = navController
            )
        }

        composable(route = AppScreens.ConfigScreen.route) {
            ConfigScreen(navController)
        }
        composable(route = AppScreens.CreditsScreen.route) {
            CreditsScreen(navController)
        }
    }
}