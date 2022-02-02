package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Test

class AuthTDD {

    @Test
  fun  login_completeFrom_existUser_returnsSuccessEvent(){
     val isAuthencated = userAuthenticationTDD("ant@gmail.com", "1234")
        Assert.assertEquals(AuthEvent.USER_EXIST, isAuthencated)
    }

    @Test
  fun  login_completeForm_notExistUser_returnsFailEvent(){
     val isAuthencated = userAuthenticationTDD("nt@gmail.com", "1234")
        Assert.assertEquals(AuthEvent.NOT_USER_EXIST, isAuthencated)
    }

    @Test
    fun  login_emptyEmail_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("", "1234")
        Assert.assertEquals(AuthEvent.EMTY_EMAIL, isAuthencated)
    }

    @Test
    fun  login_emptyPassword_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmail.com", "")
        Assert.assertEquals(AuthEvent.EMTY_PASSWORD, isAuthencated)
    }

    @Test
    fun  login_emptyForm_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("", "")
        Assert.assertEquals(AuthEvent.EMTY_FORM, isAuthencated)
    }


    /*

       login_completeForm_invalidEmail_returnsFailEvent
       login_completeForm_invalidPassword_returnsFailEvent
       login_completeForm_invalidUser_returnsFailEvent
       login_nullEmail_returnsException
       login_nullPassword_returnsException
       login_nullForm_returnsException
       login_completeForm_errorLengthPassword_returnsFailEvent*/

}