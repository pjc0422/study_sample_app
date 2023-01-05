package com.example.sampleapp.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.R
import com.example.sampleapp.ui.theme.SampleAppTheme

class HomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        findNavController().navigateUp()

        return ComposeView(requireContext()).apply {
            setContent {
                SampleAppTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.White
                    ) {

                        Column {
                            Button(onClick = {
                                findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
                            }) {
                                Text(text = "Go to Setting")
                            }
                            Button(onClick = {
                                findNavController().navigate(R.id.action_homeFragment_to_todayFragment)
                            }) {
                                Text(text = "Go to Today")
                            }
                        }
                    }
                }
            }
        }
    }
}
