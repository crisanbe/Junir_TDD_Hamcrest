package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Test

class AuthTDD {

    @Test
  fun  login_completeFrom_existUser_returnsSuccessEvent(){
     val isAuthencated = userAuthenticationTDD("ant@gmail.com", "1234")
        Assert.assertEquals(AuthEvent.USER_EXIST, isAuthencated)
    }

 /*   login_completeForm_notExistUser_returnsFailEvent
    login_emptyEmail_returnsFailEvent
    login_emptyPassword_returnsFailEvent
    login_emptyForm_returnsFailEvent
    login_completeForm_invalidEmail_returnsFailEvent
    login_completeForm_invalidPassword_returnsFailEvent
    login_completeForm_invalidUser_returnsFailEvent
    login_nullEmail_returnsException
    login_nullPassword_returnsException
    login_nullForm_returnsException
    login_completeForm_errorLengthPassword_returnsFailEvent*/

}