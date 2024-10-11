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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.ui.theme.LobsterTwoFont

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController){
    Scaffold(){
        MainScreenBodyContent(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenBodyContent(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4FA))
    ) {
        NavbarMenu(navController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Mis entradas",
                textAlign = TextAlign.Center,
                fontSize = 35.sp,
                fontWeight = FontWeight(400),
                fontFamily = LobsterTwoFont,
                color = Color(0xFFF61067)

            )

            Spacer(modifier = Modifier.height(20.dp))

            for (i in 1..6) {
                EntryCard("Título $i", "Fecha/de/creación", navController)
                Spacer(modifier = Modifier.height(16.dp))
            }


            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(R.drawable.editar),
                contentDescription = "Edit Icon",
                modifier = Modifier
                    .size(36.dp)
                    .clickable(onClick = {
                        navController.navigate(route = "new_entry_screen")
                    })
            )
        }
    }
}

@Composable
fun EntryCard(title: String, creationDate: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .clickable (onClick = {
                navController.navigate(route = "entry_detail_screen")
            }),
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFC4EB)) // Color de fondo rosa
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                )
                Text(
                    text = creationDate,
                    style = TextStyle(
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen()
}*/
