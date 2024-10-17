package co.edu.upb.pinkyblinders.ui.theme

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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EntryDetailScreen(titulo: String?, fecha: String?, descripcion: String?, navController: NavController) {
    Scaffold {
        EntryDetailBodyContent(
            titulo = titulo,
            fecha = fecha,
            descripcion = descripcion,
            navController = navController
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryDetailBodyContent(fecha: String?,
                           titulo: String?,
                           descripcion: String?,
                           navController: NavController) {
    val defaultFecha = "Fecha/de/entrada"
    val defaultTitulo = "Título de la entrada"
    val defaultDescripcion = "Este es un ejemplo de una entrada de diario. Aquí puedes escribir todo lo que te ha sucedido hoy, tus pensamientos y cómo te has sentido a lo largo del día. Este espacio está diseñado para que puedas reflexionar sobre tus experiencias, grandes o pequeñas, y sobre cómo estas te han impactado. Tal vez tu día ha sido tranquilo y has disfrutado de pequeños momentos de paz, o quizás ha sido más agitado, lleno de retos y emociones intensas. No importa qué tipo de día hayas tenido, este es un lugar seguro para desahogarte y expresar todo lo que llevas dentro.\n\nEste diario también puede ser un buen lugar para reflexionar sobre tus metas, lo que te gustaría alcanzar en los próximos días o semanas, y cómo te sientes con respecto a tu progreso. Tómate el tiempo para escribir con calma, sin prisa, y aprovecha este momento para conectar contigo mismo."

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4FA)),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // Navbar
        Navbar(navController)

        Spacer(modifier = Modifier.height(20.dp))

        //Fecha
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = fecha ?: defaultFecha,
            color = Color(0xFFF61067),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(10.dp))


        //Título
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Espacio entre el título y los iconos
        ) {
            // Título
            Text(
                text = titulo ?: defaultTitulo,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = LobsterTwoFont,
                color = Color(0xFFF61067)
            )

            // Iconos de editar y eliminar
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.editar),
                    contentDescription = "Editar",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            // pendiente: programar el editar
                        }
                )

                Image(
                    painter = painterResource(id = R.drawable.eliminar),
                    contentDescription = "Eliminar",
                    modifier = Modifier
                        .size(30.dp) //
                        .clickable {
                            // pendiente: programar el eliminar
                        }
                )
            }
        }

        //Texto de la entrada
        Text(
            modifier = Modifier.padding(25.dp),
            text = descripcion ?: defaultDescripcion,
            fontWeight = FontWeight.Normal,
            fontSize = 19.sp,
            color = Color.Black
        )


    }
}

/*@Preview(showBackground = true)
@Composable
fun EntryDetailScreenPreview() {
    EntryDetailScreen(titulo = null, fecha = null, descripcion = null)
}*/
