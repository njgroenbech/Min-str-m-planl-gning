import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.minstrmplanlgning.domain.model.NavItem

@Composable
fun NavigationBar(navController: NavController) {
    val navItems = listOf(
        NavItem("Priser", Icons.Default.Search),
        NavItem("Forbrug", Icons.Default.Search),
        NavItem("Find selskab", Icons.Default.Search),
        NavItem("Planlæg", Icons.Default.List),
        NavItem("Profil", Icons.Default.Person)
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            tonalElevation = 8.dp,
            shadowElevation = 8.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                navItems.forEach { (route, icon) ->
                    Column(
                        modifier = Modifier
                            .height(50.dp)
                            // navigation between different screens in navBar
                            .clickable {
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    restoreState = true
                                }
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = route,
                            tint = Color.Gray
                        )
                        Text(
                            text = route,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}