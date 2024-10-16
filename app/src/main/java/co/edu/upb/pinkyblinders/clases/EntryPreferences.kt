package co.edu.upb.pinkyblinders.clases

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class EntryPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("entry_prefs", Context.MODE_PRIVATE)
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

    fun deleteEntryById(id: String) {
        val entries = getEntries().toMutableList() // Obtiene la lista de entradas
        val entryToDelete = entries.find { it.id == id }
        entryToDelete?.let {
            entries.remove(it) // Elimina la entrada encontrada
            saveEntries(entries) // Guarda la lista actualizada
        }

    }
    // Editar una entrada por ID
    fun editEntryById(id: String, newTitle: String?, newDescription: String?, newDate: String?) {
        val entries = getEntries().toMutableList() // Obtiene la lista de entradas
        val entryToEdit = entries.find { it.id == id } // Encuentra la entrada por ID

        entryToEdit?.let {
            // Si la entrada existe, modifica sus propiedades
            it.titulo = newTitle ?: it.titulo
            it.descripcion = newDescription ?: it.descripcion
            it.fechaCreacion = newDate ?: it.fechaCreacion

            // Guarda la lista actualizada
            saveEntries(entries)
        }
    }


    // Limpiar entradas
        fun clearEntries() {
            prefs.edit().remove("entry_list").apply()
        }

    }
