package com.example.usw_random_chat.ui

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.usw_random_chat.R

@Composable
fun button(text: String, enable: Boolean, content: Color, back: Color, modifier: Modifier) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = back,
            contentColor = content
        ),
        enabled = enable,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            lineHeight = 20.sp,
            fontWeight = FontWeight(600),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun copyRightByFlag(modifier: Modifier) {
    Text(
        text = "@copyright by Flag",
        fontSize = 12.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
        fontWeight = FontWeight(400),
        color = Color(0xFF767676),
        textAlign = TextAlign.Center,
        letterSpacing = 0.3.sp,
        modifier = modifier
    )
}
@Composable
fun portalEmail(textFieldValue: String, onValueChange: (String) -> Unit){

    TextField(
        value = textFieldValue,
        onValueChange = { newValue -> onValueChange(newValue) },
        placeholder = { Text("포털 이메일 입력") },
        trailingIcon = { Text("@ suwon.ac.kr    ", color = Color(0xFF000000)) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        modifier = Modifier
            .width(326.dp)
            .heightIn(
                min = 56.dp
            )
    )
}
