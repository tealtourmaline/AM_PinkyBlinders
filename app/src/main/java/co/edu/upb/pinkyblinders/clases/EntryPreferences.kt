package co.edu.upb.pinkyblinders.clases

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class EntryPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("entry_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    // Guardar lista de entradas
    fun saveEntries(entries: List<Entry>) {
        val json = gson.toJson(entries)
        prefs.edit().apply {
            putString("entry_list", json)
            apply()
        }
    }

    // Obtener lista de entradas
    fun getEntries(): List<Entry> {
        val json = prefs.getString("entry_list", null)
        val type: Type = object : TypeToken<List<Entry>>() {}.type
        return if (json != null) {
            gson.fromJson(json, type)
        } else {
            emptyList() // Retorna una lista vacía si no hay datos
        }
    }
    // Obtener entrada por ID
    fun getEntryById(id: String): Entry? {
        val entries = getEntries() // Obtiene la lista de entradas
        return entries.find { it.id == id } // Busca la entrada por ID
    }



    // Limpiar entradas
    fun clearEntries() {
        prefs.edit().remove("entry_list").apply()
    }
}
