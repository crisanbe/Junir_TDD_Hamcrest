package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Test

class AuthTDD {

    //correo y contraseña correctos
    @Test
  fun  login_completeFrom_existUser_returnsSuccessEvent(){
     val isAuthencated = userAuthenticationTDD("ant@gmail.com", "1234")
        Assert.assertEquals(AuthEvent.USER_EXIST, isAuthencated)
    }

    //correo electronico no existe
    @Test
  fun  login_completeForm_notExistUser_returnsFailEvent(){
     val isAuthencated = userAuthenticationTDD("nt@gmail.com", "1234")
        Assert.assertEquals(AuthEvent.NOT_USER_EXIST, isAuthencated)
    }

    //campo correo vacio
    @Test
    fun  login_emptyEmail_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("", "1234")
        Assert.assertEquals(AuthEvent.EMTY_EMAIL, isAuthencated)
    }

    //campo password vacio
    @Test
    fun  login_emptyPassword_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmail.com", "")
        Assert.assertEquals(AuthEvent.EMTY_PASSWORD, isAuthencated)
    }

    //campos vacios
    @Test
    fun  login_emptyForm_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("", "")
        Assert.assertEquals(AuthEvent.EMTY_FORM, isAuthencated)
    }

    //Correo electronico no valido, formato incorrecto
    @Test
    fun  login_completeForm_invalidEmail_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmailcom", "1234")
        Assert.assertEquals(AuthEvent.INVALID_EMAIL, isAuthencated)
    }

    //campo contraseña , formato incorrecto
    @Test
    fun  login_completeForm_invalidPassword_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmail.com", "123e")
        Assert.assertEquals(AuthEvent.INVALID_PASSWORD, isAuthencated)
    }

    //campos  invalidos
    @Test
    fun  login_completeForm_invalidUser_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmailcom", "123e")
        Assert.assertEquals(AuthEvent.INVALID_USER, isAuthencated)
    }


    /*
       login_nullEmail_returnsException
       login_nullPassword_returnsException
       login_nullForm_returnsException
       login_completeForm_errorLengthPassword_returnsFailEvent*/

}