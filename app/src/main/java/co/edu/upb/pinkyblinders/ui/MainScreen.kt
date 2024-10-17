package co.edu.upb.pinkyblinders.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.clases.Entry
import co.edu.upb.pinkyblinders.ui.theme.LobsterTwoFont

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController, entriesList: List<Entry>) {
    Scaffold(containerColor = Color(0xFFFFE4FA)) {
        MainScreenBodyContent(navController, entriesList)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenBodyContent(navController: NavController, entriesList: List<Entry>) {
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

        entriesList.forEach { entry ->
            EntryCard(entry, navController) // Pasando el objeto entry completo
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

@Composable
fun EntryCard(entry: Entry, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .clickable(onClick = {
                navController.navigate("entry_detail_screen/${entry.id}")
            }),
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFC4EB))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = entry.titulo,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                )
                Text(
                    text = entry.fechaCreacion,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
            }
        }
    }
}

