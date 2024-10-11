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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.upb.pinkyblinders.R
import co.edu.upb.pinkyblinders.ui.theme.LoginScreen

@Composable
fun NavbarMenu(navController: NavController) {
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
            contentDescription = "Opciones",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.navigate(route = "config_screen")
                }
        )

        Image(
            painter = painterResource(id = R.drawable.logohorizontal),
            contentDescription = "Logo",
            modifier = Modifier
                .height(28.dp),

            )
    }
}