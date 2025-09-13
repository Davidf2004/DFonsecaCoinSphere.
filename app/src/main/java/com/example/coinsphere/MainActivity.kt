@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.coinsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

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
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Text("CoinSphere", color = TextMain)
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