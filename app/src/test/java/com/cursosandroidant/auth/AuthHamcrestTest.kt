package com.cursosandroidant.auth


import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*//importar `is` de hamcrest
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class AuthHamcrestTest {
    //todo (sujeto a aprobar) - (Accion o estado actual de la prueba) - (resultado que esteramos del Test)
    //GIVEN-WHEN-THEN
    //todo (dado)-(cuándo)-(entonces)

    @Test
    fun  loginUser_correctData_returnsSuccessEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is`(result) )
    }

    //correo electronico no existe
    @Test
    fun  loginUser_wrongData_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("nt@gmail.com", "1234")
        Assert.assertEquals(AuthEvent.NOT_USER_EXIST, isAuthencated)
    }

    //campo correo vacio
    @Test
    fun  loginUser_emptyEmail_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("", "1234")
        Assert.assertEquals(AuthEvent.EMTY_EMAIL, isAuthencated)
    }

    //campo password vacio
    @Test
    fun  loginUser_emptyPassword_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmail.com", "")
        Assert.assertEquals(AuthEvent.EMTY_PASSWORD, isAuthencated)
    }

    //campos vacios
    @Test
    fun  loginUser_emptysFields_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("", "")
        Assert.assertEquals(AuthEvent.EMTY_FORM, isAuthencated)
    }

    //Correo electronico no valido, formato incorrecto
    @Test
    fun  loginUser_invalidEmailFormat_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmailcom", "1234")
        Assert.assertEquals(AuthEvent.INVALID_EMAIL, isAuthencated)
    }

    //campo contraseña , formato incorrecto
    @Test
    fun  loginUser_invalidPasswordFormat_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmail.com", "123e")
        Assert.assertEquals(AuthEvent.INVALID_PASSWORD, isAuthencated)
    }

    //campos  invalidos
    @Test
    fun  loginUser_invalidUserFormat_returnsFailEvent(){
        val isAuthencated = userAuthenticationTDD("ant@gmailcom", "123e")
        Assert.assertEquals(AuthEvent.INVALID_USER, isAuthencated)
    }

    //campos correo electronico null
    @Test(expected = AuthExeption::class)
    fun  loginUser_nullEmailField_returnsException(){
        val isAuthencated = userAuthenticationTDD(null, "123e")
        Assert.assertEquals(AuthEvent.NULL_EMAIL, isAuthencated)
    }

    //campos password null (AssertThrows)
    @Test()
    fun  loginUser_nullPasswordField_returnsException(){
        Assert.assertThrows(AuthExeption::class.java){
            print(userAuthenticationTDD("ant@gmail.com", null))
        }

    }

    //campos correo y password estan null ()
    @Test()
    fun  loginUser_nullFields_returnsException(){
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
    @Test
    fun  loginUser_errorLengthPassword_returnsFailEvent(){
        val lenghPassword = userAuthenticationTDD("ant@gmail.com", "123")
        Assert.assertEquals(AuthEvent.LENGTH_PASSWORD, lenghPassword)
    }

}