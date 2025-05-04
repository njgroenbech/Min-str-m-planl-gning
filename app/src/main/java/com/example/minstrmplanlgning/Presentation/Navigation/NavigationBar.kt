import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.sharp.Refresh
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
import androidx.compose.material.icons.filled.Bolt


// Nicholas har arbejdet på navigation

@Composable
fun NavigationBar(navController: NavController) {
    val navItems = listOf(
        NavItem("Priser", Icons.Default.Bolt),
        NavItem("Forbrug", Icons.Default.BarChart),
        NavItem("Find selskab", Icons.Default.ImageSearch),
        NavItem("Planlæg", Icons.Default.Menu),
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
                            .clickable { // navigation between different screens in navBar
                                // check if you're not already on the same screen you're clicking on
                                if (navController.currentDestination?.route != route) {
                                    navController.navigate(route) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
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