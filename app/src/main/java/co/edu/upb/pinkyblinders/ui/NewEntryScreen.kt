package co.edu.upb.pinkyblinders.ui.theme

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.clases.Entry
import co.edu.upb.pinkyblinders.ui.Navbar
import java.util.UUID

@Composable
fun NewEntryScreen(navController: NavController, entriesList: MutableList<Entry>) {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold {
        NewEntryBodyContent(onAcceptClick = { showDialog = true }, navController, entriesList)

        if (showDialog) {
            SuccessDialog(onDismiss = { showDialog = false }, navController)
        }
    }
}

@Composable
fun SuccessDialog(onDismiss: () -> Unit, navController: NavController) {
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
                    text = "Nota creada",
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
fun NewEntryBodyContent(onAcceptClick: () -> Unit, navController: NavController, entriesList: MutableList<Entry>) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

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
            text = "Ingresa una nueva entrada",
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
                label = { Text("Cómo te sientes hoy, qué hiciste, cualquier cosa que quieras anotar") },
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

        Icon(
            painter = painterResource(id = android.R.drawable.ic_input_add), // Ícono del sistema
            contentDescription = "Aceptar",
            modifier = Modifier
                .size(36.dp)
                .clickable(onClick = {
                    val newEntry = Entry(
                        id = UUID.randomUUID().toString(),
                        titulo = title,
                        descripcion = description,
                        fechaCreacion = "Hoy"
                    )
                    entriesList.add(newEntry)
                    onAcceptClick()
                })
        )

    }
}
