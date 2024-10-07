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
import co.edu.upb.pinkyblinders.R

@Composable
fun NewEntryScreen() {
    Scaffold {
        NewEntryBodyContent()
    }
}

@Composable
fun Navbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFC4EB))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(id = R.drawable.volver),
            contentDescription = "Volver",
            modifier = Modifier
                .size(24.dp)
                .clickable { /*Acción de volver, luego se añade la funcionalidad*/ }
        )

        Image(
            painter = painterResource(id = R.drawable.logohorizontal),
            contentDescription = "Logo",
            modifier = Modifier
                .height(24.dp),

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewEntryBodyContent() {
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
        Navbar()


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
            modifier = Modifier.fillMaxWidth().padding(16.dp),
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
            modifier = Modifier.fillMaxWidth().padding(16.dp),
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
    }
}

@Preview(showBackground = true)
@Composable
fun NewEntryScreenPreview() {
    NewEntryScreen()
}
