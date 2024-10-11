package co.edu.upb.pinkyblinders.ui

import android.annotation.SuppressLint
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
import co.edu.upb.pinkyblinders.ui.Navbar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.ui.theme.LobsterTwoFont

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreditsScreen(){
    Scaffold(){
        CreditsScreenBodyContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditsScreenBodyContent(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4FA))
    ) {
        Navbar()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Créditos",
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                fontWeight = FontWeight(400),
                fontFamily = LobsterTwoFont,
                color = Color(0xFFF61067)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Image(
                    painter = painterResource(R.drawable.jero),
                    contentDescription = "Jerónimo Valencia",
                    modifier = Modifier.size(93.dp, 85.dp),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(R.drawable.`val`),
                    contentDescription = "Valeria Espinal",
                    modifier = Modifier.size(93.dp, 85.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Nombres de los integrantes
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Jerónimo Valencia",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
                Text(
                    text = "Valeria Espinal",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Imagen de Natalia
            Image(
                painter = painterResource(R.drawable.nano), // Reemplaza con la imagen de Natalia
                contentDescription = "Natalia Arboleda",
                modifier = Modifier
                    .size(103.dp, 95.dp)
                    .padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Nombre de Natalia
            Text(
                text = "Natalia Arboleda",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Descripción del proyecto
            Text(
                text = "Trabajo para la asignatura de Aplicaciones Móviles, desarrollado por estudiantes del programa de Ingeniería de Sistemas e Informática en la Universidad Pontificia Bolivariana.",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contacto
            Text(
                text = "Contacto:",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Text(
                text = "jeronimo.valencia@upb.edu.co\nvaleria.espinal@upb.edu.co\nnatalia.arboleda@upb.edu.co\n\n2024",
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
                color = Color.Black,
                textAlign = TextAlign.Center
            )


            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}


@Preview(showBackground = true)
@Composable
fun CreditsScreenPreview(){
    CreditsScreen()
}