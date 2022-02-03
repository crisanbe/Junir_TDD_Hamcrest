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
        val result = userAuthenticationTDD("nt@gmail.com", "1234")
        assertThat(AuthEvent.NOT_USER_EXIST, `is`(result))
    }

    //campo correo vacio
    @Test
    fun  loginUser_emptyEmail_returnsFailEvent(){
        val result = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMTY_EMAIL, `is`(result))
    }

    //campo password vacio
    @Test
    fun  loginUser_emptyPassword_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "")
        assertThat(AuthEvent.EMTY_PASSWORD, `is`(result))
    }

    //campos vacios
    @Test
    fun  loginUser_emptysFields_returnsFailEvent(){
        val result = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMTY_FORM, `is`(result))
    }

    //Correo electronico no valido, formato incorrecto
    @Test
    fun  loginUser_invalidEmailFormat_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(result))
    }

    //campo contraseña , formato incorrecto
    @Test
    fun  loginUser_invalidPasswordFormat_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmail.com", "123e")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(result))
    }

    //campos  invalidos
    @Test
    fun  loginUser_invalidUserFormat_returnsFailEvent(){
        val result = userAuthenticationTDD("ant@gmailcom", "123e")
        assertThat(AuthEvent.INVALID_USER, `is`(result))
    }

    //campos correo electronico null
    @Test(expected = AuthExeption::class)
    fun  loginUser_nullEmailField_returnsException(){
        val result = userAuthenticationTDD(null, "123e")
        assertThat(AuthEvent.NULL_EMAIL, `is`(result))
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
            assertThat(AuthEvent.NULL_FORM, `is`(result))
        } catch (e: Exception) {
            (e as? AuthExeption)?.let{
                assertThat(AuthEvent.NULL_FORM, `is`(it.authEvent))
            }
        }
    }

    //ERROR DE LONGITUD DE CARACTERES, MAXIMO 4 (PASSWORD)
    @Test
    fun  loginUser_errorLengthPassword_returnsFailEvent(){
        val lenghPassword = userAuthenticationTDD("ant@gmail.com", "123")
        assertThat(AuthEvent.LENGTH_PASSWORD,`is`(lenghPassword))
    }

    //todo (both(Hamcrest))--con nos dice si contiene o no la letra en la palabra actual
    @Test
    fun checkNames_differentUsers_match(){
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    //todo (not(Hamcrest))--En esta funcion le decimos que el correo no es igual a la contraseña
    @Test
    fun checkData_emailPassword_noMatch(){
        val email = "ant@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)))
    }

}