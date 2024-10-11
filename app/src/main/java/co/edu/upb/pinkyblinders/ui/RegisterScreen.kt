package co.edu.upb.pinkyblinders.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.ui.theme.LobsterTwoFont

@Composable
fun RegisterScreen(navController: NavController){
    Scaffold(){
        RegisterBodyContent(navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterBodyContent(navController: NavController){
    var nombre by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4FA))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenida a tu diario secreto",
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                fontWeight = FontWeight(400),
                fontFamily = LobsterTwoFont,
                color = Color(0xFFF61067)

            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.imagen_registro),
                contentDescription = "Imagen",
                modifier = Modifier
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "¿Cual es tu nombre?",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
                modifier = Modifier
                    .width(289.dp)

            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Ingresa tu nombre") },
                modifier = Modifier
                    .width(260.dp)
                    .height(40.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF61067),
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Crea una contraseña que solo tu sepas de 4 números",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
                modifier = Modifier
                    .width(289.dp)

            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = pin,
                onValueChange = {
                    if (it.length <= 4) pin = it
                },
                label = { Text("PIN") },
                placeholder = { Text("****") },
                modifier = Modifier
                    .width(260.dp)
                    .height(40.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF61067),
                        shape = RoundedCornerShape(10.dp)
                    ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

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
                    .clickable (onClick = {
                        navController.navigate("login_screen")
                    })
            ){
                Text(text = "Continuar",
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    fontSize = 25.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen()
}*/
