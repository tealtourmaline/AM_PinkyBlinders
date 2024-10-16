package co.edu.upb.pinkyblinders.clases

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUserData(name: String, pin: String) {
        prefs.edit().apply {
            putString("user_name", name)
            putString("user_pin", pin)
            apply()
        }
    }

    fun getUserName(): String? {
        return prefs.getString("user_name", null)
    }

    fun getUserPin(): String? {
        return prefs.getString("user_pin", null)
    }

    fun clearUserData() {
        prefs.edit().clear().apply()
    }
}