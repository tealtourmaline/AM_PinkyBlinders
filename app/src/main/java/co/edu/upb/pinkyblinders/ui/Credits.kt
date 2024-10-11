package co.edu.upb.pinkyblinders.ui

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
import co.edu.upb.pinkyblinders.R

@Composable
fun Credits() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFC4EB))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(id = R.drawable.menu),
            contentDescription = "Volver",
            modifier = Modifier
                .size(24.dp)
                .clickable { /*Acción de volver, luego se añade la funcionalidad*/ }
        )

        Image(
            painter = painterResource(id = R.drawable.logohorizontal),
            contentDescription = "Logo",
            modifier = Modifier
                .height(28.dp),

            )
    }
}