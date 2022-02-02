package com.cursosandroidant.auth



fun userAuthentication(email: String, password: String): Boolean {
    if (email == "ant@gmail.com" && password == "1234"){
        return true
    }
    return false
}

fun userAuthenticationTDD(email: String?, password: String?): AuthEvent {
    if (email!!.isEmpty()) return AuthEvent.EMTY_EMAIL
    if (password!!.isEmpty()) return AuthEvent.EMTY_PASSWORD

    if (email == "ant@gmail.com" && password == "1234"){
        return AuthEvent.USER_EXIST
    }
    return AuthEvent.NOT_USER_EXIST
}

fun isEmailValid(email: String): Boolean {
    val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return EMAIL_REGEX.toRegex().matches(email);
}