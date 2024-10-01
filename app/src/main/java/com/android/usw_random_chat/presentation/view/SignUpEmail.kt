package com.android.usw_random_chat.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.android.usw_random_chat.R
import com.android.usw_random_chat.presentation.ViewModel.SignUpViewModel

@Composable
fun EmailAuthScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    navController: NavController
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val onResumeAction = rememberUpdatedState {
        // 앱이 다시 활성화될 때 실행할 함수 호출
        signUpViewModel.checkEmailAuth()
        // 여기에 실행하고 싶은 로직을 추가합니다.
    }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                onResumeAction.value()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    SignUpEmail(email = signUpViewModel.email) { signUpViewModel.updateEmail(it) }
    SignUpEmailBtn()
    RequestEmail(signUpViewModel.checkAuthEmailState.value) {
        signUpViewModel.postEmail()
    }
    SignUpExitBtn { navController.popBackStack() }
    CompleteSignUp(signUpViewModel.checkAuthEmailState.value) {
        navController.navigate(Screen.SignInScreen.route) {
            popUpTo(Screen.SignInScreen.route) { inclusive = true }
        }
    }

    //Toast.makeText(LocalContext.current,"회원가입이 완료됐습니다 로그인을 진행해주세요",Toast.LENGTH_SHORT).show()

    /*if (signUpViewModel.authEmailState.value){
        navController.navigate(Screen.SignInScreen.route)
        signUpViewModel.changeAuthEmailState()
    }*/
    if (signUpViewModel.dialogAuthEmailState.value == 0) {
        OneButtonDialog(
            contentText = "이메일 전송을\n실패했습니다.",
            text = "확인",
            onPress = { signUpViewModel.changeDialogAuthEmailState() },
            image = R.drawable.baseline_error_24
        )
    }
    if (signUpViewModel.dialogAuthEmailState.value == 1) {
        OneButtonDialog(
            contentText = "인증메일이 전송되었습니다.\n전송된 인증 URL을 클릭해주세요",
            text = "확인",
            onPress = { signUpViewModel.changeDialogAuthEmailState() },
            image = R.drawable.baseline_check_circle_24
        )
    }
}


@Composable
fun SignUpExitBtn(onPress: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 60.dp
            )
    ) {
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
fun SignUpEmailBtn() {
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
                .weight(1f)
        )
        Spacer(modifier = Modifier.weight(0.3f))
    }
}

@Composable
fun RequestEmail(enable: Boolean, onPress: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 286.dp
            )
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        CustomButton(
            text = if (enable) "인증메일 재전송" else "인증메일 전송",
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

@Composable
fun CompleteSignUp(boolean: Boolean, onPress: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 360.dp
            )
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        CustomButton(
            text = "회원가입 완료",
            enable = boolean,
            content = Color.White,
            back = Color.Black,
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
@Preview(showBackground = true)
@Composable
fun EmailAuthScreenPreview() {
    val asd: State<String> = mutableStateOf("")
    SignUpEmail(email = asd) {}
    SignUpEmailBtn()
    RequestEmail(false) {}
    SignUpExitBtn {}
    CompleteSignUp(true) {}
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