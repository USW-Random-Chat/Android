package com.example.usw_random_chat.presentation.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usw_random_chat.data.dto.UserDTO
import com.example.usw_random_chat.domain.usecase.SignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInUseCase: SignInUseCase) : ViewModel() {

    private val _id = mutableStateOf("")
    private val _password = mutableStateOf("")
    private val _email = mutableStateOf("")
    private val _verifyflag = mutableStateOf(false)

    val id : State<String> = _id
    val password : State<String>  = _password
    val email : State<String>  = _email
    val verifyflag : State<Boolean>  = _verifyflag

    fun updateID(newValue : String){
        _id.value = newValue
    }

    fun updatePassWord(newValue : String){
        _password.value = newValue
    }

    fun updateEmail(newValue: String){
        _email.value = newValue
    }


    fun postSignIn(){
        viewModelScope.launch {//viewModelScope 공부하기
            signInUseCase.excute(UserDTO(id.value,password.value,email.value))
        }
    }
}