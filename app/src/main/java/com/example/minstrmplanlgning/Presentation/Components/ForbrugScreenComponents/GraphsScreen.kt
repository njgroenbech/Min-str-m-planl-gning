import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents.HouseholdComparisonCard
import com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents.PercentageSavedCard
import com.example.minstrmplanlgning.Presentation.Components.ForbrugScreenComponents.TilbageTilForbrugCard

@Composable
fun GraphsScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp) // height for header area
            ) {
                // Back button at start
                TilbageTilForbrugCard(
                    onClickNavigation = {
                        navController.navigate("Forbrug")
                    },
                )

                Text(
                    text = "Mine tal",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            PercentageSavedCard()

            Spacer(modifier = Modifier.height(24.dp))

            HouseholdComparisonCard()

            Spacer(modifier = Modifier.height(24.dp))


            // space at bottom so LazyColumn matches the navbar
            Spacer(modifier = Modifier.height(90.dp))
        }
    }
}



