package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Test

class AuthTest {
    @Test
    //nombramiento de funciones Evento/Accion/devolovión o que deberia pasar
    fun login_complete_returnsTrue(){
        val isAutenticated = userAuthentication("ant@gmail.com", "1234")
        Assert.assertTrue(isAutenticated)
    }

    @Test
    fun login_complete_returnsFalse(){
        val isAutenticated = userAuthentication("an@gmail.com", "1234")
        Assert.assertFalse(isAutenticated)
    }

    @Test
    fun login_emtyEmail_returnsFalse(){
        val isAutenticated = userAuthentication("", "1234")
        Assert.assertFalse(isAutenticated)
    }

    @Test
    fun login_NullEmail_returnsFalse(){
        val isAutenticated = userAuthenticationTDD(null, "1234")
        Assert.assertFalse(isAutenticated)
    }
    @Test
    fun login_NullPassword_returnsFalse(){
        val isAutenticated = userAuthenticationTDD("ant@gmail.com", null)
        Assert.assertFalse(isAutenticated)
    }
}