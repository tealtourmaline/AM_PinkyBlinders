package co.edu.upb.pinkyblinders.ui.theme

import co.edu.upb.pinkyblinders.ui.theme.LobsterTwoFont
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import co.edu.upb.pinkyblinders.clases.EntryPreferences
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.clases.Entry
import co.edu.upb.pinkyblinders.ui.Navbar
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.UUID

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditEntryScreen(
    navController: NavController,
    entryPreferences: EntryPreferences,
    entryId: String
) {
    var showDialog by remember { mutableStateOf(false) }
    val entriesList = remember { mutableStateListOf<Entry>() }
    var entryToEdit by remember { mutableStateOf<Entry?>(null) }

    // Cargar las entradas guardadas al iniciar
    LaunchedEffect(Unit) {
        entriesList.addAll(entryPreferences.getEntries())
        entryToEdit = entryPreferences.getEntryById(entryId)
    }

    Scaffold {
        entryToEdit?.let { entry ->
            EditEntryBodyContent(
                entry = entry,
                onAcceptClick = {
                    // Guardar entradas en SharedPreferences
                    entryPreferences.saveEntries(entriesList)
                    showDialog = true
                },
                navController,
                entriesList
            )
        }

        if (showDialog) {
            SuccessDialog2(onDismiss = { showDialog = false }, navController)
        }
    }
}
@Composable
fun SuccessDialog2(onDismiss: () -> Unit, navController: NavController) {
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0xFFFFC4EB), shape = RoundedCornerShape(10.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.exito),
                    contentDescription = "Éxito",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Entrada editada exitosamente",
                    color = Color(0xFFF61067),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(170.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFFFFC4EB),
                                        Color(0xFFF61067)
                                    )
                                ),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable(onClick = {
                                navController.popBackStack()
                            })
                    ) {
                        Text(
                            text = "Aceptar",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        },
        confirmButton = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        containerColor = Color(0xFFFFC4EB),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEntryBodyContent(
    entry: Entry,
    onAcceptClick: () -> Unit,
    navController: NavController,
    entriesList: MutableList<Entry>
) {
    var title by remember { mutableStateOf(entry.titulo) }
    var description by remember { mutableStateOf(entry.descripcion) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4FA)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Navbar(navController)

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Edita tu entrada",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = LobsterTwoFont,
            color = Color(0xFFF61067)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Titulo",
                color = Color(0xFF1C0F13),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Ingresa aquí un título") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF61067),
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Descripcion",
                color = Color(0xFF1C0F13),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Edita aquí tu descripción") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF61067),
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .height(40.dp)
                .width(170.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFFC4EB),
                            Color(0xFFF61067)
                        )
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .clickable {
                    val updatedEntry = entry.copy(
                        titulo = title,
                        descripcion = description
                    )

                    // Actualiza la lista de entradas con la entrada editada
                    val index = entriesList.indexOfFirst { it.id == entry.id }
                    if (index != -1) {
                        entriesList[index] = updatedEntry
                    }
                    onAcceptClick()
                }
        ) {
            Text(
                text = "Guardar",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
