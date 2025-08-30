package com.dappsm.kindbite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dappsm.kindbite.navigation.AppNavigation
import com.dappsm.kindbite.ui.theme.KindBiteTheme

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KindBiteTheme {
                AppNavigation()
            }
        }
    }
}
@Composable
fun ScaffoldContent() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationContent(navController) }
    ) {  innerPadding ->
        NavigationGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )

    }
}


@Composable
fun NavigationGraph(navController: NavHostController,  modifier: Modifier = Modifier){
    NavHost(navController=navController,startDestination=NavItem.Home.route){
        composable(NavItem.Home.route){
            MostrarLD()
        }
        composable(NavItem.User.route){
            MostrarCUD()
        }
        composable(NavItem.Inventory.route){
            MostrarIN()
        }
    }
}
@Composable
fun BottomNavigationContent(navController: NavHostController) {
    val items:List<NavItem> =listOf(NavItem.Home, NavItem.User, NavItem.Inventory)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 12.dp),
            contentAlignment = Alignment.Center
    ) {
        NavigationBar(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth(1f),
            windowInsets = WindowInsets(0),
            containerColor = Color(0xFFFC8D3F)
        ) {
            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(44.dp)
                        )
                    },
                    label = { null },
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let {
                                popUpTo(it) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    alwaysShowLabel = false,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFDE4F1B),
                        unselectedIconColor = Color(0xFFFFFFFF),
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

@Composable
fun MostrarMainScreen(){
    ScaffoldContent()
}
