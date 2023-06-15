package com.example.eksflorasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.eksflorasi.ui.authentication.LandingScreen
import com.example.eksflorasi.ui.authentication.LoginScreen
import com.example.eksflorasi.ui.authentication.RegisterScreen
import com.example.eksflorasi.ui.authentication.SplashScreen
import com.example.eksflorasi.ui.collection.CollectionDetailScreen
import com.example.eksflorasi.ui.collection.CollectionScreen
import com.example.eksflorasi.ui.home.DashboardScreen
import com.example.eksflorasi.ui.home.TopNavigation
import com.example.eksflorasi.ui.theme.EksFlorasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EksFlorasiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CollectionDetailScreen()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun SplashScreenPreview() {
    EksFlorasiTheme {
        SplashScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun LandingScreenPreview() {
    EksFlorasiTheme {
        LandingScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun LoginScreenPreview() {
    EksFlorasiTheme {
        LoginScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun RegisterScreenPreview() {
    EksFlorasiTheme {
        RegisterScreen()
    }
}