package com.example.sampleapp

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHost
import androidx.navigation.NavHostController

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
