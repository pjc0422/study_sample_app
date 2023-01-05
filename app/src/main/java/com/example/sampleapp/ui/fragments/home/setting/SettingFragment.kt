package com.example.sampleapp.ui.fragments.home.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                Column {
                }
            }
        }
    }
}

//data class TempModel(
//    val name: String
//)
//
//@Composable
//fun buildTempView() {
//    val state by remember {
//        mutableStateOf<TempModel>(TempModel(name= "hello world"))
//    }
//
//}
