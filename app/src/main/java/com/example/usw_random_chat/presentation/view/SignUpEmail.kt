package com.example.usw_random_chat.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.usw_random_chat.R
import com.example.usw_random_chat.presentation.ViewModel.SignUpViewModel
import com.example.usw_random_chat.ui.OneButtonDialog
import com.example.usw_random_chat.ui.CustomButton
import com.example.usw_random_chat.ui.PortalEmail
import com.example.usw_random_chat.ui.CustomText
import com.example.usw_random_chat.ui.TittleWithBackArrow

@Composable
fun EmailAuthScreen(signUpViewModel: SignUpViewModel = viewModel(), navController: NavController){
    SignUpEmail(email = signUpViewModel.email){ signUpViewModel.updateEmail(it) }
    SignUpEmailBtn()
    RequestEmail{signUpViewModel.verifyEmail()}
    SignUpExitBtn{navController.popBackStack()}

    if (signUpViewModel.authEmailState.value){
        navController.navigate(Screen.SignInScreen.route)
        signUpViewModel.changeAuthEmailState()
    }
    if(signUpViewModel.dialogAuthEmailState.value){
        OneButtonDialog(
            contentText = "이메일 전송을\n실패했습니다.",
            text = "확인",
            onPress = { signUpViewModel.changeDialogAuthEmailState() },
            image = R.drawable.baseline_error_24
        )
    }
}


@Composable
fun SignUpExitBtn(onPress: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 60.dp
            )
    ){
        Spacer(modifier = Modifier.weight(0.1f))
        TittleWithBackArrow(
            "회원가입",
            Modifier
                .height(48.dp)
                .width(100.dp)
                .weight(0.6f)
                .offset(y = 10.dp),
            onBackClick = { onPress() }
        )
        Spacer(modifier = Modifier.weight(1.1f))
    }
}


@Composable
fun SignUpEmail(
    email: State<String>,
    onValueEmail: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 143.dp
            )
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        PortalEmail(text = email, onValueChange = onValueEmail)
        Spacer(modifier = Modifier.weight(0.1f))
    }
}

@Composable
fun SignUpEmailBtn(){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 256.dp
            ),
    ) {
        Spacer(modifier = Modifier.weight(0.3f))
        CustomText(
            text1 = "*입력하신 메일로 ",
            text2 = "이메일 인증 URL",
            text3 = "을 전송합니다",
            modifier = Modifier
                .height(18.dp)
                .weight(1f))
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Composable
fun RequestEmail(onPress: () -> Unit){

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 286.dp
            )
    ){
        Spacer(modifier = Modifier.weight(0.1f))
        CustomButton(
            text = "인증메일 전송",
            enable = true,
            content = Color.White,
            back = Color(0xFF2D64D8),
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
        ) {
            onPress()
        }
        Spacer(modifier = Modifier.weight(0.1f))
    }
}



@SuppressLint("UnrememberedMutableState")
@Preview (showBackground = true)
@Composable
fun EmailAuthScreenPreview(){
    val asd : State<String> = mutableStateOf("")
    SignUpEmail(email = asd){}
    SignUpEmailBtn()
    RequestEmail{}
    SignUpExitBtn{}
}


/*@Preview (showBackground = true)
@Composable
fun SignUpExitBtnPreview(navController: NavController) {
    SignUpExitBtn(navController)
}
@Preview (showBackground = true)
@Composable
fun SignUpEmailPreview() {

    val TextState = remember {
        mutableStateOf("")
    }
    IdSearchEmail(TextState)
}*/