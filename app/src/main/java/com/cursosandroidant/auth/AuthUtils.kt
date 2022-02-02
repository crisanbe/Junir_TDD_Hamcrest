package com.cursosandroidant.auth


fun userAuthentication(email: String, password: String): Boolean {
    if (email == "ant@gmail.com" && password == "1234") {
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {
    if (email!!.isEmpty() && password!!.isEmpty()) return AuthEvent.EMTY_FORM
    if (email.isEmpty()) return AuthEvent.EMTY_EMAIL
    if (password!!.isEmpty()) return AuthEvent.EMTY_PASSWORD

    val paswordNumeric = password.toIntOrNull()//CONVERTIR STRING EN UN NUMERO

    return if (!isEmailValid(email) && paswordNumeric == null) AuthEvent.INVALID_USER
    else if (!isEmailValid(email)) AuthEvent.INVALID_EMAIL
    else if (paswordNumeric == null) AuthEvent.INVALID_PASSWORD
    else {

        return if (email == "ant@gmail.com" && password == "1234")
            AuthEvent.USER_EXIST
        else
            AuthEvent.NOT_USER_EXIST
    }


}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}