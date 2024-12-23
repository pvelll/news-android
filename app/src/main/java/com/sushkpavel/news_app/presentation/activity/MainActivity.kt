package com.sushkpavel.news_app.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sushkpavel.news_app.presentation.screens.main.MainScreen
import com.sushkpavel.news_app.presentation.theme.NewsappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NewsappTheme {
                MainScreen()
            }
        }
    }
}
