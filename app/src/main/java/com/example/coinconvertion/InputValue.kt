package com.example.coinconvertion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coinconvertion.ui.theme.CustomColors
import com.example.coinconvertion.ui.theme.Poppins
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputValue(
   coinViewModel: CoinView = viewModel()
){

    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = { newValue: String ->
            if (newValue.all { it.isDigit()}){
                var formatter_value: Double
                value = newValue
                formatter_value = convertToDouble(newValue)
                coinViewModel.changeValues(formatter_value)
            }
        },
        modifier = Modifier.padding(15.dp).wrapContentSize(),
        textStyle = TextStyle(color = Color.White, fontFamily = Poppins,fontSize = 128.sp, textAlign = TextAlign.Center),

        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Transparent
        ),

        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = MonetaryVisualTransformation()
    )

}

fun convertToDouble(txt: String): Double {
    val value = txt.toDoubleOrNull() ?: return 0.0
    return value/100
}

class MonetaryVisualTransformation: VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {

        val input = text.text
        val formatted_number = convertToDouble(input)

        val newText = AnnotatedString(
            text = "$formatted_number",
            spanStyles = text.spanStyles,
            paragraphStyles = text.paragraphStyles
        )

        val offsetMapping = MonetaryOffsetMapping(
            content_length = input.length,
            formatted_content_length = "$formatted_number".length
        )

        return TransformedText(newText, offsetMapping)
    }

}

class MonetaryOffsetMapping(
    private val content_length: Int,
    private val formatted_content_length: Int
) : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int = formatted_content_length

    override fun transformedToOriginal(offset: Int): Int = content_length

}


@Preview
@Composable
fun PreviewInputValue(){
    InputValue()
}