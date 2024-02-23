package com.example.coinconvertion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coinconvertion.ui.theme.CustomColors

@Composable
fun CardResult(coin: State<Double>, symbol: Char, value: Double, title: String, flag: Painter, imgDescription: String){
    Row(
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = flag,
            contentDescription = imgDescription,
            modifier = Modifier.size(48.dp).clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(text = title, fontWeight = FontWeight.Bold,color = Color.White)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("1 Real (BRL)", fontWeight = FontWeight.Light, fontSize = 12.sp,color = Color.White)
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "seta para a direita",
                    tint = Color.White,
                    modifier = Modifier.size(12.dp)
                )
                Text("$value $title", fontWeight = FontWeight.Light, fontSize = 12.sp,color = Color.White)
            }
//            Text("1 Real \u2192 $value", fontWeight = FontWeight.Light, fontSize = 12.sp,color = Color.White)
            Text("${getValue(coin)} $symbol", fontSize = 24.sp, color = CustomColors.primary)
        }
    }
}

fun getValue(state: State<Double>):String {
    return String.format("%.2f", state.value)
}