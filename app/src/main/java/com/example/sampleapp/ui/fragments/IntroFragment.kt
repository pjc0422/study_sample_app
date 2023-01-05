package com.example.sampleapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.createGraph
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.sampleapp.R
import com.example.sampleapp.ui.theme.SampleAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class IntroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        checkLogin()

        return ComposeView(requireContext()).apply {
            setContent {
                SampleAppTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        IntroContent()
                    }
                }
            }
        }
    }


    @Composable
    fun IntroContent() {
        Box {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }


    private fun checkLogin() {
        CoroutineScope(Dispatchers.IO).launch {
            ///TODO : check login user
            withContext(Dispatchers.IO) {
                Thread.sleep(1000)
            }
            launch(Dispatchers.Main) {
                println("call navigate")
//                findNavController().navigate(R.id.action_introFragment_to_loginFragment)
                findNavController().setGraph(R.navigation.login_navigation)

                
            }
        }
    }
}
