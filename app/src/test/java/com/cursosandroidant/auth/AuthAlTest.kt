package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class AuthAlTest {
    private var email: String? = null
    private var password: String? = null

    @Before//ANTES
    fun setup() {
        email = "ant@gmail.com"//Moficiamos segun el Test que vayamos a probar.
        password = "1234"
    }

    //correo y contraseña correctos(ant@gmail.com,1234)
    @Test
    fun login_completeFrom_existUser_returnsSuccessEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.USER_EXIST, isAuthencated)
    }

    //correo electronico no existe(nt@gmail.com,1234)
    @Test
    fun login_completeForm_notExistUser_returnsFailEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.NOT_USER_EXIST, isAuthencated)
    }

    //campo correo vacio("".com,1234)
    @Test
    fun login_emptyEmail_returnsFailEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMTY_EMAIL, isAuthencated)
    }

    //campo password vacio(ant@gmail.com,"")
    @Test
    fun login_emptyPassword_returnsFailEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMTY_PASSWORD, isAuthencated)
    }

    //campos vacios("","")
    @Test
    fun login_emptyForm_returnsFailEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.EMTY_FORM, isAuthencated)
    }

    //Correo electronico no valido, formato incorrecto(ant@gmailcom,1234)
    @Test
    fun login_completeForm_invalidEmail_returnsFailEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_EMAIL, isAuthencated)
    }

    //campo contraseña , formato incorrecto(ant@gmail.com,123e)
    @Test
    fun login_completeForm_invalidPassword_returnsFailEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_PASSWORD, isAuthencated)
    }

    //campos  invalidos(ant@gmailcom,123e)
    @Test
    fun login_completeForm_invalidUser_returnsFailEvent() {
        val isAuthencated = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.INVALID_USER, isAuthencated)
    }

    //campos correo electronico null(null,123e)
    @Test(expected = AuthExeption::class)
    fun login_nullEmail_returnsException() {
        try {
            val result = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_EMAIL, result)
        } catch (e: Exception) {
            (e as? AuthExeption)?.let {
                Assert.assertEquals(AuthEvent.NULL_EMAIL, it.authEvent)
            }
        }
    }

    //campos password null (AssertThrows)(ant@gmail.com,null)
    @Test()
    fun login_nullPassword_returnsException() {
        try {
            val result = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_PASSWORD, result)
        } catch (e: Exception) {
            (e as? AuthExeption)?.let {
                Assert.assertEquals(AuthEvent.NULL_PASSWORD, it.authEvent)
            }
        }


    }

    //campos correo y password estan null / (null,null)
    @Test()
    fun login_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(email, password)
            Assert.assertEquals(AuthEvent.NULL_FORM, result)
        } catch (e: Exception) {
            (e as? AuthExeption)?.let {
                Assert.assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }

    //ERROR DE LONGITUD DE CARACTERES, MAXIMO 4 (PASSWORD)(ant@gmail.com,123)
    //@Ignore("FALTA DEFINIR UN REQUISITO DEL CLIENTE...")//ANOTACION TEMPORAL HASTA QUE SE REFACTORICE LAS DEFINICIONES POR EL CLIENTE.
    @Test
    fun login_completeForm_errorLengthPassword_returnsFailEvent() {
        val lenghPassword = userAuthenticationTDD(email, password)
        Assert.assertEquals(AuthEvent.LENGTH_PASSWORD, lenghPassword)
    }

}