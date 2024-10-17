package co.edu.upb.pinkyblinders.ui.theme

import android.annotation.SuppressLint
import android.widget.Toast
import co.edu.upb.pinkyblinders.ui.theme.LobsterTwoFont


import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.ui.text.style.TextAlign

import co.edu.upb.pinkyblinders.ui.Navbar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.clases.EntryPreferences
import co.edu.upb.pinkyblinders.clases.UserPreferences

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ConfigScreen(navController: NavController) {
    var showConfirmationDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }
    var showSuccessDialog2 by remember { mutableStateOf(false) }
    var showSuccessDialog3 by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val userPreferences = UserPreferences(context)
    val entryPreferences = EntryPreferences(context)

    // Obtenemos el nombre del usuario al cargar la pantalla
    var nombre by remember { mutableStateOf(userPreferences.getUserName() ?: "") }
    var pinActual by remember { mutableStateOf("") }  // Inicia como cadena vacía
    var pinNuevo by remember { mutableStateOf("") }   // Inicia como cadena vacía

    Scaffold {
        ConfigBodyContent(
            nombre = nombre,
            pinActual = pinActual,
            pinNuevo = pinNuevo,
            onNombreChange = { nombre = it }, // Permitir la edición del nombre
            onAceptarClick = {
                // Guardamos el nuevo nombre cuando se hace clic en "Aceptar"
                userPreferences.saveUserData(name = nombre, pin = userPreferences.getUserPin() ?: "")
                showSuccessDialog2 = true
            },
            onPinActualChange = { pinActual = it },
            onPinNuevoChange = { pinNuevo = it },
            onCambiarPinClick = {
                // Verificar que el PIN actual coincida con el almacenado
                if (pinActual == userPreferences.getUserPin()) {
                    // Si coincide, guardar el nuevo PIN
                    userPreferences.saveUserData(
                        name = nombre,
                        pin = pinNuevo,
                    )
                    showSuccessDialog3 = true // Mostrar éxito
                } else {
                    // Manejar el error de PIN incorrecto
                    Toast.makeText(context, "PIN actual incorrecto", Toast.LENGTH_LONG).show()
                }
            },
            onDeleteDataClick = { showConfirmationDialog = true },
            navController = navController,

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
        SuccessDialogConfig(onDismiss = { showSuccessDialog = false }, navController, userPreferences, entryPreferences)
    }
    // Diálogo de éxito 2
    if (showSuccessDialog2) {
        SuccessDialogConfig2(onDismiss = { showSuccessDialog2 = false }, navController, userPreferences)
    }

    if (showSuccessDialog3) {
        SuccessDialogConfig3(onDismiss = { showSuccessDialog3 = false }, navController, userPreferences)
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
                    fontSize = 20.sp,
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
fun ConfigBodyContent(
    nombre: String,
    pinActual: String,
    pinNuevo: String,
    onNombreChange: (String) -> Unit,
    onAceptarClick: () -> Unit,
    onPinActualChange: (String) -> Unit,
    onPinNuevoChange: (String) -> Unit,
    onCambiarPinClick: () -> Unit,
    onDeleteDataClick: () -> Unit,
    navController: NavController
) {

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
            text = "Tu configuración",
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
                text = "Nombre",
                color = Color(0xFF1C0F13),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo para editar el nombre del usuario
            TextField(
                value = nombre,
                onValueChange = onNombreChange,
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
                            .clickable { /* Ya se puede editar el campo */ }
                            .size(24.dp),
                        tint = Color(0xFFF61067)
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón Aceptar para guardar el nombre editado
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
                .clickable(onClick = onAceptarClick) // Llamamos a la función onAceptarClick
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
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
                value = pinActual,
                onValueChange = onPinActualChange,
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
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
                value = pinNuevo,
                onValueChange = onPinNuevoChange,
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
                .clickable(onClick = onCambiarPinClick)
        ) {
            Text(
                text = "Aceptar",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .height(30.dp)
                .width(140.dp)
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
                text = "Creditos",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable(onClick = {navController.navigate(route = "credits_screen")})
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

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
fun SuccessDialogConfig(onDismiss: () -> Unit, navController: NavController, userPreferences: UserPreferences, entryPreferences: EntryPreferences) {
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
                        .clickable(onClick = {

                            userPreferences.clearUserData()
                            entryPreferences.clearEntries()
                            navController.navigate(route = "register_screen"){
                                popUpTo(navController.graph.id) { inclusive = true }
                            }
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
@Composable
fun SuccessDialogConfig3(onDismiss: () -> Unit, navController: NavController, userPreferences: UserPreferences) {
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
                        .clickable(onClick = {
                            navController.navigate(route = "login_screen")
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
        },
        text = {
            Text(
                text = "Pin cambiado exitosamente",
                color = Color(0xFFF61067),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    )
}
@Composable
fun SuccessDialogConfig2(onDismiss: () -> Unit, navController: NavController, userPreferences: UserPreferences) {
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
                        .clickable(onClick = {
                            navController.navigate(route = "config_screen")
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
        },
        text = {
            Text(
                text = "Nombre cambiado exitosamente",
                color = Color(0xFFF61067),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    )
}


/*@Preview(showBackground = true, name = "ConfigScreenPreview")
@Composable
fun ConfigScreenPreview() {
    ConfigScreen()
}*/
