package com.example.usw_random_chat.presentation.view

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.usw_random_chat.R


@Composable
fun WebViewBottomSheet(url: String, text: String, onPress: () -> Unit) {
    WebViewScreen(url = url)
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        BottomAppBar(
            backgroundColor = Color.White
        ) {
            Button(
                onClick = { onPress() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF4D76C8)
                )
            )
            {
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun WebViewScreen(url: String) {
    val context = LocalContext.current
    AndroidView(modifier = Modifier.fillMaxSize(), factory = {
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}
