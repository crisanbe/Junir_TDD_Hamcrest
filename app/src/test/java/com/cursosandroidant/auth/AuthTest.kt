package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Test

class AuthTest {
    @Test
    //nombramiento de funciones Evento/Accion/devolovion o que deberia pasar
    fun login_complete_returnsTrue(){
        val isAutenticated = userAuthentication("ant@gmail.com", "1234")
        Assert.assertTrue(isAutenticated)
    }

    @Test
    //nombramiento de funciones Evento/Accion/devolovion o que deberia pasar
    fun login_complete_returnsFalse(){
        val isAutenticated = userAuthentication("an@gmail.com", "1234")
        Assert.assertFalse(isAutenticated)
    }
}