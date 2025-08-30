package com.dappsm.kindbite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class LoginViewModel: ViewModel() {
    private val _usuario= MutableLiveData<String>("")
    val usuario:LiveData<String> =_usuario

    private val _contrasena= MutableLiveData<String>("")
    val contrasena:LiveData<String> =_contrasena

    private val _loginResult = MutableLiveData<Boolean?>(null)
    val loginResult: LiveData<Boolean?> = _loginResult
    private val _loginEnable= MutableLiveData<Boolean>()
    val loginEnable:LiveData<Boolean> =_loginEnable

    fun onLoginChanged(us:String,co:String){
        _usuario.value=us
        _contrasena.value=co
        _loginEnable.value = us.isNotEmpty() && co.isNotEmpty()
    }

    fun login(navController: NavController):Boolean {
        val us = _usuario.value ?: ""
        val co = _contrasena.value ?: ""
        val result = compararUsuarios(us, co, navController)
        return result

    }
    fun resetLoginResult() {
        _loginResult.value = null
    }
    }

