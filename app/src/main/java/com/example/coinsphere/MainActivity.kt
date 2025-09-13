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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
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

data class Crypto(val name: String, val price: String, val logoUrl: String)

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
fun CryptoRow(position: Int, crypto: Crypto) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(position.toString(), color = TextDim, fontSize = 12.sp, modifier = Modifier.width(20.dp))
                Spacer(Modifier.width(12.dp))
                Text(crypto.name, color = MaterialTheme.colorScheme.onSurface, fontSize = 15.sp, fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
                Text(crypto.price, color = MaterialTheme.colorScheme.onSurface, fontSize = 14.sp)
            }
            Divider(color = Separator, thickness = 1.dp)
        }
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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
    Column(Modifier.fillMaxSize().padding(vertical = 20.dp)) {
        Text("CoinSphere", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground)
        Spacer(Modifier.height(16.dp))
        InfoCard("Global Market Cap", "$2.18T"); Spacer(Modifier.height(12.dp))
        InfoCard("Fear & Greed", "Neutral (54)"); Spacer(Modifier.height(12.dp))
        InfoCard("Altcoin Season", "No"); Spacer(Modifier.height(20.dp))

        Row(Modifier.fillMaxWidth().padding(bottom = 8.dp, start = 16.dp, end = 16.dp), verticalAlignment = Alignment.CenterVertically) {
            Text("#", color = TextDim, fontSize = 12.sp, modifier = Modifier.width(20.dp))
            Text("Name", color = TextDim, fontSize = 12.sp, modifier = Modifier.weight(1f))
            Text("Price", color = TextDim, fontSize = 12.sp)
        }
        Divider(color = Separator, thickness = 5.dp)

        Spacer(Modifier.height(15.dp))
    }
}

@Preview(name = "HomeScreen", showBackground = true, backgroundColor = 0xFF0B1020)
@Composable
fun PreviewHomeScreen() {
    MaterialTheme(colorScheme = CoinSphereColors) {
        Box(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            HomeScreen()
        }
    }
}