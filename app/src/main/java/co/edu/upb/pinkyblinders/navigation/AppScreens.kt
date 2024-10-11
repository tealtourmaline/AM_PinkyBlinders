package co.edu.upb.pinkyblinders.navigation

sealed class AppScreens (val route:String){
    object SplashScreen: AppScreens("splash_screen")
    object RegisterScreen: AppScreens("register_screen")
    object NewEntryScreen: AppScreens("new_entry_screen")
    object MainScreen: AppScreens("main_screen")
    object LoginScreen: AppScreens("login_screen")
    object EntryDetailScreen: AppScreens("entry_detail_screen")
    object CreditsScreen: AppScreens("credits_screen")
    object ConfigScreen: AppScreens("config_screen")
}