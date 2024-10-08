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
    Scaffold {
        ConfigBodyContent()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigBodyContent() {
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
        // Navbar
        Navbar()


        // Título centrado
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Tu configuración",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontFamily = LobsterTwoFont,
            color = Color(0xFFF61067)
        )


        // Campo de título
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
                        painter = painterResource(id = R.drawable.editar),  // Asegúrate de que este ícono esté en tu carpeta drawable
                        contentDescription = "Editar",
                        modifier = Modifier
                            .clickable { /* Acción de editar */ }
                            .size(24.dp),  // Tamaño del ícono
                        tint = Color(0xFFF61067)  // Color del ícono
                    )
                }
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

        //subtítulo: cambiar clave

        Text(
            text = "Cambiar clave",
            color = Color(0xFFF61067),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),

            )
        //Apartado para que el usuario ingrese su clave actual

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
        Spacer(modifier = Modifier.height(12.dp))

        // Botón "Aceptar" para la clave
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

        // Botón "Borrar todos los datos"
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
                .clickable(onClick = { /*Funcionalidad de aceptar, tarea pendiente*/ })
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

@Preview(showBackground = true)
@Composable
fun ConfigScreenPreview() {
    ConfigScreen()
}
