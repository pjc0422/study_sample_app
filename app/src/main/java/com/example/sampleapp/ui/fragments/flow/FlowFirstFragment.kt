package com.example.sampleapp.ui.fragments.flow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sampleapp.R
import com.example.sampleapp.ui.theme.SampleAppTheme

class FlowFirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val value = savedInstanceState?.getInt("return")

        return ComposeView(requireContext()).apply {
            setContent {
                SampleAppTheme {
                    Scaffold {
                        LazyColumn(content = {
                            item {
                                Text("value : $value")
                            }

                            item {
                                Text("first item", modifier = selectCells(0))
                            }

                            items(5) { index ->
                                Text("index : $index", modifier = selectCells(index + 1))
                            }

                            item {
                                Text("last item", modifier = selectCells(5))
                            }
                        })
                    }
                }
            }
        }
    }


    private fun selectCells(key: Int) = Modifier.clickable {
        val bundle = Bundle()
        bundle.putInt("return", key)
        findNavController().navigate(R.id.action_flowFirstFragment_to_flowSecondFragment, bundle)
    }
}
