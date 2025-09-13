@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.coinsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Background = Color(0xFF0B1020)
private val Surface    = Color(0xFF151B2E)
private val TextMain   = Color(0xFFE8ECF8)
private val TextDim    = Color(0xFF9AA3B2)
private val Accent     = Color(0xFF2B6BE9)
private val Separator  = Color.White.copy(alpha = 0.12f)

private val CoinSphereColors = darkColorScheme(
    primary      = Accent,
    onPrimary    = Color.White,
    surface      = Surface,
    onSurface    = TextMain,
    background   = Background,
    onBackground = TextMain
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme(colorScheme = CoinSphereColors) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(horizontal = 16.dp)
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, color = TextDim, fontSize = 12.sp)
            Spacer(Modifier.height(8.dp))
            Text(value, color = MaterialTheme.colorScheme.onSurface, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text("CoinSphere", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
        Spacer(Modifier.height(16.dp))
        InfoCard("Global Market Cap", "$2.18T"); Spacer(Modifier.height(12.dp))
        InfoCard("Fear & Greed", "Neutral (54)"); Spacer(Modifier.height(12.dp))
        InfoCard("Altcoin Season", "No")
    }
}

@Preview(name = "HomeScreen", showBackground = true, backgroundColor = 0xFF0B1020)
@Composable
fun PreviewHomeScreen() {
    MaterialTheme(colorScheme = CoinSphereColors) {
        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            HomeScreen()
        }
    }
}