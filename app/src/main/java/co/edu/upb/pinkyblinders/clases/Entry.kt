package co.edu.upb.pinkyblinders.clases

import java.util.UUID
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Entry(
    val id: String = UUID.randomUUID().toString(),
    var titulo: String,
    var descripcion: String,
    var fechaCreacion: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
)
