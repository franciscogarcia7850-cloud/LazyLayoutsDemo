package com.example.lazylayoutsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lazylayoutsdemo.ui.PantallaListas
import com.example.lazylayoutsdemo.ui.theme.LazyLayoutsDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyLayoutsDemoTheme {
                PantallaListas()
            }
        }
    }
}
