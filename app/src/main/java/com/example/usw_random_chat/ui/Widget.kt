package com.example.usw_random_chat.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.usw_random_chat.R


@Composable
fun madeAccount(){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 562.dp
            )
    ) {
        Spacer(modifier = Modifier.weight(0.4f))
        Divider(
            color = Color(0xFFBFBFBF),
            modifier = Modifier
                .weight(1f)
                .padding(top = 9.dp)
        )
        Spacer(modifier = Modifier.weight(0.3f))

        Text(
            text = "계정이 없으신가요?",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontSize = 14.sp
            ),
            modifier = Modifier
                .weight(1.3f)
        )
        Spacer(modifier = Modifier.weight(0.3f))

        Divider(
            color = Color(0xFFBFBFBF),
            modifier = Modifier
                .weight(1f)
                .padding(top = 9.dp)
        )
        Spacer(modifier = Modifier.weight(0.4f))
    }
}

@Composable
fun loginFindIdAndPassword(){

    TextButton(
        onClick = {},
        modifier = Modifier
    ) {
        Text(
            text = "아이디 찾기",
            color = Color(0xFF232323),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular))
            )
        )
    }
    Spacer(modifier = Modifier.width(8.dp))
    Image(
        painter = painterResource(id = R.drawable.rectangle),
        contentDescription = "image description",
        modifier = Modifier
            .width(10.dp)
            .height(32.dp)
            .padding(top = 15.dp)
    )
    Spacer(modifier = Modifier.width(8.dp))
    TextButton(
        onClick = {},
        modifier = Modifier

    ) {
        Text(
            text = "비밀번호 찾기",
            color = Color(0xFF232323),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_regular))
            ),
        )
    }
}


@Composable
fun loginTextField(
    text: MutableState<String>,
    isPassword: Boolean
) {
    Row() {
        Spacer(modifier = Modifier.weight(0.1f))
        OutlinedTextField(
            value = text.value,
            onValueChange = { textValue -> text.value = textValue },
            shape = RoundedCornerShape(10.dp),
            placeholder = {
                Text(
                    text = if (isPassword) "PASSWORD" else "ID",
                    color = Color(0xFF989898),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard_regular))
                    ),
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                )
            },
            modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .background(color = Color.White),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        )
        Spacer(modifier = Modifier.weight(0.1f))
    }
}


@Composable
fun button(
    text: String,
    enable: Boolean,
    content: Color,
    back: Color,
    modifier: Modifier,
    onPress: () -> Unit
) {
    Button(
        onClick = onPress,
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
            textAlign = TextAlign.Center,
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
fun tittleWithBackArrow(text: String, modifier: Modifier) {


    Row(
        Modifier, //horizontalArrangement = Arrangement.Center
    )
    {
        Spacer(Modifier.weight(0.1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack, contentDescription = "",
                Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .weight(0.1f)

            )
        }
        Spacer(Modifier.weight(0.25f))
        Text(
            text = buildAnnotatedString {
                append(text)
            },
            fontSize = 18.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight(600),
            color = Color(0xFF111111),
            textAlign = TextAlign.Center,
            modifier = modifier
        )
        Spacer(Modifier.weight(0.5f))
    }
}

@Composable
fun portalEmail(textFieldValue: String, onValueChange: (String) -> Unit) {
    TextField(
        value = textFieldValue,
        onValueChange = { newValue -> onValueChange(newValue) },
        placeholder = {
            Text(
                "포털 이메일 입력", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF989898)
                )
            )
        },
        trailingIcon = {
            Text(
                "@ suwon.ac.kr    ", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        modifier = Modifier
            .width(326.dp)
        //.heightIn(min = 46.dp)

    )
}

@Composable
fun idSearchBtn(
    textFieldIdValue: String,
    onValueChange: (String) -> Unit,
    idLengthCheck: Boolean,
    onPress: () -> Unit
) {
    val screenWidthInDp = (GetScreenWidthInDp() - 326) / 2

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            //.width(360.dp)
            .padding(start = screenWidthInDp.dp, top = 3.dp, end = screenWidthInDp.dp)
            .border(
                width = 1.dp, color = Color(0xFFBFBFBF),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        TextField(
            value = textFieldIdValue,
            onValueChange = { idValue -> onValueChange(idValue) },
            placeholder = { Text(text = "아이디 입력 (4~16자)", color = Color.Gray) },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent, // 포커스되었을 때의 밑줄 색상
                unfocusedIndicatorColor = Color.Transparent, // 포커스가 해제되었을 때의 밑줄 색상
                disabledIndicatorColor = Color.Transparent // 비활성화되었을 때의 밑줄 색상
            ),
            modifier = Modifier
                .weight(0.8f)
        )
        Button(
            enabled = !idLengthCheck,
            onClick = onPress,
            modifier = Modifier
                //.padding(start = 30.dp)
                .align(Alignment.CenterVertically)
                .width(100.dp)
                .height(40.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color(0xFF2D64D8)
            ),
        ) {
            Text(text = "중복 확인")
        }
        Spacer(Modifier.weight(0.02f))
    }
}

@Composable
fun MatchingAnimationText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 40.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.kcc_chassam)),
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),
        )
    )
}

@Composable
fun sendImg(id: Int) {
    Image(
        painter = painterResource(id = R.drawable.send),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .width(42.dp)
            .height(42.dp)
            .background(Color(0xFFF8F8F8), shape = RoundedCornerShape(25.dp))
    )
}

@Composable
fun TwoButtonDialog(
    contentText: String,
    leftText: String,
    rightText: String,
    leftonPress: () -> Unit,
    rightonPress: () -> Unit,
    image: Int
) {
    Dialog(
        onDismissRequest = leftonPress,
    ) {
        Column(
            modifier = Modifier
                .width(270.dp)
                .height(164.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 24.dp)
            )
            Text(
                text = contentText,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF767676),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
            ) {

                Spacer(modifier = Modifier.weight(0.1f))
                Button(
                    onClick = leftonPress,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFF1F1F1),
                        contentColor = Color(0xFF767676)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                ) {
                    Text(
                        text = leftText,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                            fontWeight = FontWeight(600),
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
                Button(
                    onClick = rightonPress,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF2D64D8),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                ) {
                    Text(
                        text = rightText,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
            }
        }
    }

}

@Composable
fun msg(text: String, color: Color) {
    Box(
        Modifier
            .padding(start = 6.dp, end = 6.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFDBDBDB),
                shape = RoundedCornerShape(size = 25.dp)
            )
            .background(
                color = color,
                shape = RoundedCornerShape(size = 25.dp)
            ),
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                top = 10.dp,
                start = 17.dp,
                end = 17.dp,
                bottom = 12.dp
            ), // 패딩 추가,
            fontSize = 16.sp,
            lineHeight = 18.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight(400),
            color = Color(0xFF191919),
        )
    }

}

@Composable
fun TimeText() {
    Text(
        text = "오후" + "3:12",
        fontSize = 12.sp,
        lineHeight = 14.sp,
        fontFamily = FontFamily(Font(R.font.kcc_chassam)),
        fontWeight = FontWeight(400),
        color = Color(0xFF767676),
        modifier = Modifier
            .width(42.dp)
            .height(14.dp)
    )
}

@Composable
fun OneButtonDialog(
    contentText: String,
    text: String,
    onPress: () -> Unit,
    image: Int
) {
    Dialog(
        onDismissRequest = onPress,
    ) {
        Column(
            modifier = Modifier
                .width(270.dp)
                .height(164.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "image description",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 24.dp)
            )
            Text(
                text = contentText,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF767676),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
            ) {

                Spacer(modifier = Modifier.weight(0.1f))
                Button(
                    onClick = onPress,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF2D64D8),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(44.dp)
                ) {
                    Text(
                        text = text,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 18.sp,
                            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(0.1f))
            }
        }
    }
}

@Composable
fun drawerMenu(image: Int, menuName: String, onPress: () -> Unit) {
    Button(
        onClick = onPress,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        Icon(
            painter = painterResource(id = image), contentDescription = "", modifier = Modifier
                .width(25.dp)
                .height(25.dp), tint = Color.Gray
        )
        Text(
            text = menuName,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
            fontWeight = FontWeight(400),
            color = Color(0xFF111111),
            textAlign = TextAlign.Center,
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_chevron_right_24),
            contentDescription = "",
        )

    }

}

@Preview(showBackground = true)
@Composable
fun TwoButtonDialogPreview() {
    //TwoButtonDialog("신고하시겠습니까?", "취소", "신고하기", {}, {}, R.drawable.baseline_error_24)
    OneButtonDialog(
        contentText = "qlfl",
        text = "sdfaewf",
        onPress = { /*TODO*/ },
        image = R.drawable.baseline_check_circle_24
    )
}

@Preview(showBackground = true)
@Composable
fun draweMenuPreview() {
    drawerMenu(image = R.drawable.profile_img, menuName = "이용약관") {

    }
}

@Composable
fun GetScreenWidthInDp(): Int {
    val context = LocalContext.current
    val density = LocalDensity.current.density
    val screenWidthInPx = context.resources.displayMetrics.widthPixels
    return (screenWidthInPx / density).toInt()
}

@Composable
fun GetScreenHeightInDp(): Int {
    val context = LocalContext.current
    val density = LocalDensity.current.density
    val screenHeightInPx = context.resources.displayMetrics.heightPixels
    return (screenHeightInPx / density).toInt()
}

@Composable
fun RedWarning(warningText: String,modifier: Modifier){
    Text(
        text = warningText,
        fontFamily = FontFamily(Font(R.font.pretendard_regular)),
        fontSize = 12.sp,
        lineHeight = 14.sp,
        fontWeight = FontWeight(400),
        color = Color(0xFFFF0000),
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}