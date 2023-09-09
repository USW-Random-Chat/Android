package com.example.usw_random_chat.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.usw_random_chat.R
import com.example.usw_random_chat.ui.button


@Composable
fun SignInScreen(navController: NavController) {
    val editidState = remember {
        mutableStateOf("")
    }
    val editpasswordState = remember {
        mutableStateOf("")
    }
    LoginTextField(id = editidState, password = editpasswordState)
    OnLoginBtn(navController)
    OnLoginFindIdAndPassword()
    MadeAccountText()
    OnSignInBtn(navController)
    OnLoginImage()
}
@Composable
fun OnLoginImage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 63.dp),
        contentAlignment = Alignment.TopEnd
    ){
        Image(
            painter = painterResource(id = R.drawable.balloon),
            contentDescription = "image description",
            modifier = Modifier
                .width(380.dp)
                .height(268.dp),
            alignment = Alignment.TopEnd
        )
    }
}


@Composable
fun LoginTextField(
    id: MutableState<String>,
    password: MutableState<String>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 365.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = id.value,
            onValueChange = {idValue -> id.value = idValue},
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    text = "ID",
                    color = Color(0xFF989898),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular))
                    )
                )
            },
            modifier = Modifier
                .width(326.dp)
                .height(48.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = {passwordValue -> password.value = passwordValue},
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    text = "PASSWORD",
                    color = Color(0xFF989898),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular))
                    )
                )
            },
            modifier = Modifier
                .width(326.dp)
                .height(48.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
    }
}

@Composable
fun OnLoginBtn(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 491.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        button(
            text = "로그인",
            enable = true,
            content = Color.White,
            back = Color(0xFF2D64D8),
            modifier = Modifier
                .width(326.dp)
                .height(56.dp)
        ){
            navController.navigate(Screen.MainPageScreen.route){
                popUpTo(Screen.MainPageScreen.route){
                    inclusive = true
                }
            }
        }
    }
}

@Composable
fun OnLoginFindIdAndPassword() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 544.dp
            ),
        horizontalArrangement = Arrangement.Center
    ) {
        TextButton(
            onClick = {}
        ) {
            Text(
                text = "아이디 찾기",
                color = Color(0xFF232323),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.pretendard_regular))
                )
            )
        }
        Spacer(
            modifier = Modifier
                .width(7.dp)
        )
        Text(
            text = "/",
            modifier = Modifier
                .padding(
                    top = 15.dp
                ),
            color = Color(0xFFBFBFBF),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular))
            )
        )

        Spacer(
            modifier = Modifier
                .width(7.dp)
        )
        TextButton(
            onClick = {}
        ) {
            Text(
                text = "비밀번호 찾기",
                color = Color(0xFF232323),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.pretendard_regular))
                )
            )
        }
    }
}


@Composable
fun MadeAccountText() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 609.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Divider(
            color = Color(0xFFBFBFBF),
            thickness = 1.dp,
            modifier = Modifier
                .width(105.dp)
                .padding(
                    top = 8.dp,
                    end = 20.dp
                )
        )
        Text(
            text = "계정이 없으신가요?",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular))
            )
        )
        Divider(
            color = Color(0xFFBFBFBF),
            thickness = 1.dp,
            modifier = Modifier
                .width(105.dp)
                .padding(
                    top = 8.dp,
                    start = 20.dp
                )
        )
    }
}

@Composable
fun OnSignInBtn(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 643.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        button(
            "회원가입",
            enable = true,
            Color.White,
            Color.Black,
            Modifier
                .width(326.dp)
                .height(56.dp),
        ){
            navController.navigate(Screen.SignUpScreen.route)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    //SignInScreen(navController = nav)
}


@Preview(showBackground = true)
@Composable
fun OnLoginBtnPreview() {
    //OnLoginBtn()
}


@Preview(showBackground = true)
@Composable
fun OnLoginFindIdAndPasswordPreview() {
    OnLoginFindIdAndPassword()
}

@Preview(showBackground = true)
@Composable
fun MadeAccountTextPreview() {
    MadeAccountText()
}


@Preview(showBackground = true)
@Composable
fun OnSignInBtnPreview() {
    //OnSignInBtn()
}


@Preview(showBackground = true)
@Composable
fun OnLoginImagePreview() {
    OnLoginImage()
}