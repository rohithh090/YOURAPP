package com.focusfeed.android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class BiteCardModel(val id: String, val headline: String, val body: String, val quote: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF121212)) {
                    val cards = listOf(
                        BiteCardModel("1", "Carnot Thermal Efficiency", "Efficiency depends solely on temperatures: ? = 1 - (T2/T1).", "? = 1 - T2/T1"),
                        BiteCardModel("2", "Reversible Processes", "A quasi-static process can be reversed without net entropy gain.", "A process is reversible only if...")
                    )
                    val pagerState = rememberPagerState(pageCount = { cards.size })
                    VerticalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
                        Card(modifier = Modifier.fillMaxSize().padding(16.dp), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E))) {
                            Column(modifier = Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.SpaceBetween) {
                                Text("CONCEPT", color = Color(0xFF00E5FF), fontWeight = FontWeight.Bold)
                                Column {
                                    Text(cards[page].headline, style = MaterialTheme.typography.headlineMedium, color = Color.White)
                                    Spacer(Modifier.height(16.dp))
                                    Text(cards[page].body, color = Color(0xFFE0E0E0))
                                    Spacer(Modifier.height(24.dp))
                                    Text("Source Citation: " + cards[page].quote, color = Color.Gray)
                                }
                                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00E5FF))) {
                                    Icon(Icons.Default.Quiz, contentDescription = null, tint = Color.Black)
                                    Spacer(Modifier.width(8.dp))
                                    Text("Quick Quiz", color = Color.Black)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
