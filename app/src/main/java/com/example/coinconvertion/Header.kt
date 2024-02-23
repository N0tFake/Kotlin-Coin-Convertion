package com.example.coinconvertion

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(){

    Box(
        modifier = Modifier.fillMaxWidth().padding(top = 32.dp, end = 15.dp, start = 15.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            "Valor em Real(BRL)",
            fontSize = 24.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }

}


@Preview
@Composable
fun HeaderPreview(){
    Header()
}