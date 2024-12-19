package com.sushkpavel.news_app.presentation.screens.main

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sushkpavel.news_app.presentation.navigation.AppNavGraph
import com.sushkpavel.news_app.presentation.navigation.routes.BottomNavigation

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
        ?: BottomNavigation.NEWS.route::class.qualifiedName.orEmpty()
    val currentRouteTrimmed by remember(currentRoute) {
        derivedStateOf { currentRoute.substringBefore("?") }
    }
    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigation.entries
                    .forEachIndexed { index, navigationItem ->
                        val isSelected by remember(currentRoute) {
                            derivedStateOf { currentRouteTrimmed == navigationItem.route::class.qualifiedName }
                        }
                        NavigationBarItem(
                            selected = isSelected,
                            label = { Text(navigationItem.label) },
                            icon = {
                                Icon(
                                    navigationItem.icon,
                                    contentDescription = navigationItem.label
                                )
                            },
                            onClick = {
                                navController.navigate(navigationItem.route)
                            }
                        )
                    }
            }
        }
    ) { innerPadding ->
        AppNavGraph(
            navController = navController,
            context = LocalContext.current,
            paddingValues = innerPadding
        )
    }
}

@Preview
@Composable
fun mainScreenPreview(){
    MainScreen()
}


