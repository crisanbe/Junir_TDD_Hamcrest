package com.cursosandroidant.auth



fun userAuthentication(email: String, password: String): Boolean {
    if (email == "ant@gmail.com" && password == "1234"){
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {
    if (email!!.isEmpty() && password!!.isEmpty()) return AuthEvent.EMTY_FORM
    if (email.isEmpty()) return AuthEvent.EMTY_EMAIL
    if (password!!.isEmpty()) return AuthEvent.EMTY_PASSWORD

    val paswordNumeric = password.toIntOrNull()//CONVERTIR STRING EN UN NUMERO
    if (password.isNotEmpty() && paswordNumeric == null )return AuthEvent.INVALID_PASSWORD
    if (email.isNotEmpty() && !isEmailValid(email) )return AuthEvent.INVALID_EMAIL


    if (email == "ant@gmail.com" && password == "1234"){
        return AuthEvent.USER_EXIST
    }
    return AuthEvent.NOT_USER_EXIST
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}