package com.example.sampleapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.sampleapp.ui.theme.SampleAppTheme

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SampleAppTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        LoginContent()
                    }
                }
            }
        }
    }


    @Composable
    fun LoginContent() {
        val userName = remember {
            mutableStateOf(TextFieldValue())
        }

        val pw = remember {
            mutableStateOf(TextFieldValue())
        }
        val response = remember {
            mutableStateOf("")
        }

        // in the below line, we are creating a column.
        Column(
            // in the below line, we are adding a modifier to it
            // and setting max size, max height and max width
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth(),

            // in the below line, we are adding vertical
            // arrangement and horizontal alignment.
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // in the below line, we are creating a text
            Text(
                // in the below line, we are specifying text as
                // Session Management in Android.
                text = "login",

                // in the below line, we are specifying text color.
                color = Color.Green,

                fontSize = 20.sp,

                // in the below line, we are specifying font family
                fontFamily = FontFamily.Default,

                // in the below line, we are adding font weight
                // and alignment for our text
                fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
            )

            //in the below line, we are adding spacer
            Spacer(modifier = Modifier.height(5.dp))

            // in the below line, we are creating a text field for our email.
            TextField(
                // in the below line, we are specifying value for our email text field.
                value = userName.value,

                // in the below line, we are adding on value change for text field.
                onValueChange = { userName.value = it },

                // in the below line, we are adding place holder as text as "Enter your email"
                placeholder = { Text(text = "Enter your name") },

                // in the below line, we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // in the below line, we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                // in the below line, we ar adding single line to it.
                singleLine = true,

                )

            // in the below line, we are adding spacer
            Spacer(modifier = Modifier.height(5.dp))

            // in the below line, we are creating a text field for our email.
            TextField(
                // in the below line, we are specifying value for our email text field.
                value = pw.value,

                // in the below line, we are adding on value change for text field.
                onValueChange = { pw.value = it },

                // in the below line, we are adding place holder as text as "Enter your email"
                placeholder = { Text(text = "Enter your pw") },

                // in the below line, we are adding modifier to it
                // and adding padding to it and filling max width
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),

                // in the below line, we are adding text style
                // specifying color and font size to it.
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                // in the below line, we ar adding single line to it.
                singleLine = true,
            )

            // in the below line, we are adding spacer
            Spacer(modifier = Modifier.height(10.dp))

            // in the below line, we are creating a button
            Button(
                onClick = {

                    // in the below line, we are calling make payment method to update data.
                    checkLogin(
                        userName, pw, response
                    )
                },
                // in the below line, we are adding modifier to our button.
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // in the below line, we are adding text for our button
                Text(text = "Update Data", modifier = Modifier.padding(8.dp))
            }

            // in the below line, we are adding a spacer.
            Spacer(modifier = Modifier.height(20.dp))

            // in the below line, we are creating a text for displaying a response.
            Text(
                text = response.value,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }

    private fun checkLogin(
        userName: MutableState<TextFieldValue>,
        pw: MutableState<TextFieldValue>,
        result: MutableState<String>
    ) {

        /// 특이하게 main thread가 아니어도 state에 값을 대입해도 해당 state는 화면에 반영이 된다.
        Runnable {
            /// sleep for test
            Thread.sleep(4000)

            result.value = "hello world ${userName.value.text}, ${pw.value.text}"
        }.run()

    }

}



