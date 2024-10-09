package co.edu.upb.pinkyblinders.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.edu.upb.pinkyblinders.R

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
                .height(28.dp),

            )
    }
}