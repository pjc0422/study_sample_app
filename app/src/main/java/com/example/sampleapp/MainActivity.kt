package com.example.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    }

    override fun onBackPressed() {
//        findNavController(R.id.content_view).popBackStack().let{
//            if(!it) {
//                super.onBackPressed()
//            }
//        }
    }
}


class SampleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppNavHost(
                modifier = Modifier.height(100.dp),
            )
        }
    }
}


@Composable
fun MyAppNavHost (
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
) {

    /// Temp code
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "Intro"
    ) {
        composable("Intro") {
            // screen
            IntroScreen(navController = navController)
        }

        composable("Join") {
            JoinScreen(navController)
        }
    }
}
@Composable
fun IntroScreen (navController: NavController) {
    // ... TODO
}

@Composable
fun JoinScreen(navController: NavController) {
    Column {
        Button(onClick = {
            navController.navigate("Intro")
        }) {
            Text(text = "Test Button")
        }
    }
}
