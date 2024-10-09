package co.edu.upb.pinkyblinders.ui.theme

import co.edu.upb.pinkyblinders.ui.theme.LobsterTwoFont


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
import co.edu.upb.pinkyblinders.R

@Composable
fun ConfigScreen() {
    var showConfirmationDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    Scaffold {
        ConfigBodyContent(
            onDeleteDataClick = { showConfirmationDialog = true }
        )
    }

    // Diálogo de confirmación
    if (showConfirmationDialog) {
        AlertDialogConfig(
            onDismiss = { showConfirmationDialog = false },
            onConfirm = {
                showConfirmationDialog = false
                showSuccessDialog = true
            }
        )
    }

    // Diálogo de éxito
    if (showSuccessDialog) {
        SuccessDialogConfig(onDismiss = {
            showSuccessDialog = false
        })
    }
}
@Composable
fun AlertDialogConfig(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        containerColor = Color(0xFFFFC4EB),
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // Texto de confirmación
                Text(
                    text = "¿Estás seguro de que quieres eliminar todos tus datos?",
                    color = Color(0xFFF61067),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        },
        confirmButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly // Espacio uniforme entre los botones
            ) {
                // Botón "SÍ"
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(80.dp)
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
                            onConfirm()
                        }
                ) {
                    Text(
                        text = "SÍ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp)) // Espacio entre los botones

                // Botón "NO"
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(80.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFFFC4EB),
                                    Color(0xFFF61067)
                                )
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { onDismiss() }
                ) {
                    Text(
                        text = "NO",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigBodyContent(onDeleteDataClick: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var pinactual by remember { mutableStateOf("") }
    var pinnuevo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4FA)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Navbar()

        Text(
            modifier = Modifier.padding(16.dp),
            text = "Tu configuración",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = LobsterTwoFont,
            color = Color(0xFFF61067)
        )

        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        ) {
            Text(
                text = "Nombre",
                color = Color(0xFF1C0F13),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre del usuario") },
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
                ),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.editar),
                        contentDescription = "Editar",
                        modifier = Modifier
                            .clickable { /* Acción de editar */ }
                            .size(24.dp),
                        tint = Color(0xFFF61067)
                    )
                }
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
                .clickable(onClick = { /*Funcionalidad de aceptar, tarea pendiente*/ })
        ) {
            Text(
                text = "Aceptar",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Cambiar clave",
            color = Color(0xFFF61067),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        )

        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        ) {
            Text(
                text = "Clave actual",
                color = Color(0xFF1C0F13),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = pinactual,
                onValueChange = { pinactual = it },
                label = { Text("Ingresa aquí tu clave actual") },
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
                ),
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        ) {
            Text(
                text = "Clave nueva",
                color = Color(0xFF1C0F13),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = pinnuevo,
                onValueChange = { pinnuevo = it },
                label = { Text("Ingresa aquí tu clave nueva") },
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
                ),
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

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
                .clickable(onClick = { /*Funcionalidad de aceptar, tarea pendiente*/ })
        ) {
            Text(
                text = "Aceptar",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(45.dp))

        Box(
            modifier = Modifier
                .height(120.dp)
                .width(170.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFCB0C54),
                            Color(0xFF1C0F13)
                        )
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
                .clickable(onClick = onDeleteDataClick)
        ) {
            Text(
                text = "Borrar todos tus datos",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun SuccessDialogConfig(onDismiss: () -> Unit) {
    AlertDialog(
        containerColor = Color(0xFFFFC4EB),
        onDismissRequest = onDismiss,
        confirmButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly // Espacio uniforme entre los botones
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
                        .clickable(onClick = onDismiss)
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
        },
        text = {
            Text(
                text = "Datos borrados exitosamente",
                color = Color(0xFFF61067),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    )
}
@Preview(showBackground = true, name = "ConfigScreenPreview")
@Composable
fun ConfigScreenPreview() {
    ConfigScreen()
}
