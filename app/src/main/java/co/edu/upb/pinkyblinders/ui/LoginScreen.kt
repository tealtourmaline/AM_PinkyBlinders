package co.edu.upb.pinkyblinders.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import co.edu.upb.pinkyblinders.R

@Composable
fun LoginScreen(){
    Scaffold(){
        LoginBodyContent()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBodyContent(){
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
                text = "Este es el diario secreto de @nombre",
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                fontWeight = FontWeight(400),
                fontFamily = LobsterTwoFont,
                color = Color(0xFFF61067)

            )

            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.imagen_login),
                contentDescription = "Imagen",
                modifier = Modifier
                    .height(300.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Ingresa tu contraseña de 4 digitos para confirmar que eres tu",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight(500),
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
                    .clickable (onClick = { /*TODO*/ })
            ){
                Text(text = "Ingresar",
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    fontSize = 25.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}