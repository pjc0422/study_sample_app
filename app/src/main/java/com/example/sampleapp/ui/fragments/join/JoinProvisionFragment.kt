package com.example.sampleapp.ui.fragments.join

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.R

class JoinProvisionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Column(verticalArrangement = Arrangement.Center) {
                    Button(onClick = {
                        findNavController().popBackStack()
                    }) {
                        Text("Back")
                    }


                    Box {
                        Button(onClick = {
//                           findNavController().navigate(R.id.action_global_main_navigation)
                            findNavController().setGraph(R.navigation.home_navigation)
                        }, modifier = Modifier.align(Alignment.Center)) {
                            Text("Finish")
                        }
                    }
                }
            }
        }
    }
}
