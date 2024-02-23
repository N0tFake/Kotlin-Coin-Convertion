package com.example.coinconvertion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coinconvertion.ui.theme.CustomColors

@Composable
fun ResultCoins(
    coinView: CoinView = viewModel()
){

    val dollar = coinView.dollar.collectAsState()
    val euro = coinView.euro.collectAsState()
    val libra = coinView.libra.collectAsState()
    val yuan = coinView.yuan.collectAsState()

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
//            .fillMaxWidth()
            .background(CustomColors.BackgroundSecundary)
            .padding(start = 10.dp, end = 10.dp)
    ) {

        CardResult(coin = dollar, title = "Dólar (USD)", symbol = '$', value = 5.0, flag = painterResource(R.drawable.eua), imgDescription = "Flag EUA")
        Divider(color = CustomColors.Background, thickness = 1.dp)

        CardResult(coin = euro, title = "Euro (EUR)", symbol = '€', value = 5.30, flag = painterResource(R.drawable.eu), imgDescription = "Flag EUA")
        Divider(color = CustomColors.Background, thickness = 1.dp)

        CardResult(coin = libra, title = "Libra (GBP)", symbol = '£', value = 6.30, flag = painterResource(R.drawable.england), imgDescription = "Flag EUA")
        Divider(color = CustomColors.Background, thickness = 1.dp)

        CardResult(coin = yuan, title = "Renminbi/Yuan (CNY)", symbol = '¥', value = 0.69, flag = painterResource(R.drawable.china), imgDescription = "Flag EUA")

    }
}
