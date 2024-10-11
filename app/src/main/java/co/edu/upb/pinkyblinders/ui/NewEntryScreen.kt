package co.edu.upb.pinkyblinders.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.ui.Navbar

@Composable
fun NewEntryScreen(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold {
        NewEntryBodyContent(onAcceptClick = { showDialog = true }, navController)

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
                    .padding(16.dp) // Añadido para un poco de padding
                    .background(Color(0xFFFFC4EB), shape = RoundedCornerShape(10.dp)), // Aseguramos el fondo
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Imagen "exito.png"
                Image(
                    painter = painterResource(id = R.drawable.exito),
                    contentDescription = "Éxito",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Texto "Nota creada"
                Text(
                    text = "Nota creada",
                    color = Color(0xFFF61067),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botón "Aceptar" centrado
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center // Centra el botón
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
fun NewEntryBodyContent(onAcceptClick: () -> Unit, navController: NavController) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4FA)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Navbar
        Navbar(navController)

        // Título centrado
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Ingresa una nueva entrada",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = LobsterTwoFont,
            color = Color(0xFFF61067)
        )

        // Campo de título
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
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions.Default,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )
        }

        // Campo de descripción
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
                visualTransformation = VisualTransformation.None,
                keyboardOptions = KeyboardOptions.Default,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón "Aceptar"
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
                .clickable(onClick = onAcceptClick)
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

/*@Preview(showBackground = true)
@Composable
fun NewEntryScreenPreview() {
    NewEntryScreen()
}*/
