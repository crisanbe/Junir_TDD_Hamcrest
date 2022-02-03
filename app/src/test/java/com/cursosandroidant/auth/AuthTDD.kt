package com.cursosandroidant.auth

import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import java.lang.NullPointerException

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

    //campos correo electronico null
    @Test(expected = AuthExeption::class)
    fun  login_nullEmail_returnsException(){
        val isAuthencated = userAuthenticationTDD(null, "123e")
        Assert.assertEquals(AuthEvent.NULL_EMAIL, isAuthencated)
    }

    //campos password null (AssertThrows)
    @Test()
    fun  login_nullPassword_returnsException(){
        Assert.assertThrows(AuthExeption::class.java){
            print(userAuthenticationTDD("ant@gmail.com", null))
        }

    }

    //campos correo y password estan null ()
    @Test()
    fun  login_nullForm_returnsException(){
        try {
            val result = userAuthenticationTDD(null, null)
            Assert.assertEquals(AuthEvent.NULL_FORM, result)
        } catch (e: Exception) {
            (e as? AuthExeption)?.let{
                Assert.assertEquals(AuthEvent.NULL_FORM, it.authEvent)
            }
        }
    }

    //ERROR DE LONGITUD DE CARACTERES, MAXIMO 4 (PASSWORD)
    @Ignore("FALTA DEFINIR UN REQUISITO DEL CLIENTE...")//ANOTACION TEMPORAL HASTA QUE SE REFACTORICE LAS DEFINICIONES POR EL CLIENTE.
    @Test
    fun  login_completeForm_errorLengthPassword_returnsFailEvent(){
        val lenghPassword = userAuthenticationTDD("ant@gmail.com", "123")
        Assert.assertEquals(AuthEvent.LENGTH_PASSWORD, lenghPassword)
    }



}