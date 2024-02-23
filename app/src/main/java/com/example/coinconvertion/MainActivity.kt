package com.example.coinconvertion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coinconvertion.ui.theme.CoinConvertionTheme
import androidx.lifecycle.ViewModel
import com.example.coinconvertion.ui.theme.CustomColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel by viewModels<CoinView>()

        setContent {
            CoinConvertionTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = CustomColors.Background
                ) {

                    Column(
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    ) {
                        Header()
                        InputValue()
                        ResultCoins()
                    }
                }
            }
        }
    }
}
