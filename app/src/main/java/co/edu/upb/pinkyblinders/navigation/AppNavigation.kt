package co.edu.upb.pinkyblinders.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.rememberNavController
import co.edu.upb.pinkyblinders.clases.Entry
import co.edu.upb.pinkyblinders.ui.CreditsScreen
import co.edu.upb.pinkyblinders.ui.MainScreen
import co.edu.upb.pinkyblinders.ui.RegisterScreen
import co.edu.upb.pinkyblinders.clases.EntryPreferences
import co.edu.upb.pinkyblinders.ui.SplashScreen
import co.edu.upb.pinkyblinders.ui.theme.ConfigScreen
import co.edu.upb.pinkyblinders.ui.theme.EntryDetailScreen
import co.edu.upb.pinkyblinders.ui.theme.LoginScreen
import co.edu.upb.pinkyblinders.ui.theme.NewEntryScreen

@Composable
fun AppNavigation(context: Context) {
    val navController = rememberNavController()
    val entryPreferences = EntryPreferences(context)

    // Crear la lista mutable de entradas
    val entriesList = remember { mutableStateListOf<Entry>() }

    // Cargar las entradas desde SharedPreferences
    val loadedEntries = entryPreferences.getEntries()
    if (loadedEntries != null) {
        entriesList.addAll(loadedEntries)
    }

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(route = AppScreens.NewEntryScreen.route) {
            NewEntryScreen(navController, entryPreferences) // Pasa EntryPreferences aquí
        }
        composable(route = AppScreens.MainScreen.route) {
            MainScreen(navController, entryPreferences)
        }
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreens.EntryDetailScreen.route + "/{entryId}") { backStackEntry ->
            val entryId = backStackEntry.arguments?.getString("entryId")
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

    // Guardar entradas en SharedPreferences cuando se añade una nueva entrada
    DisposableEffect(Unit) {
        onDispose {
            entryPreferences.saveEntries(entriesList)
        }
    }
}
