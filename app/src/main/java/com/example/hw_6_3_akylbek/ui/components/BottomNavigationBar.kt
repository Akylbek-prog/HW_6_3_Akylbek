package com.example.hw_6_3_akylbek.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(val title: String, val route: String, val icon: ImageVector)

@Composable
fun BottomNavigationBar(
    currentRoute: String,
    onTabSelected: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem("Characters", "characters", Icons.Default.Person),
        BottomNavItem("Locations", "locations", Icons.Default.LocationOn),
        BottomNavItem("Episodes", "episodes", Icons.Default.List)
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = { onTabSelected(item.route) }
            )
        }
    }
}
