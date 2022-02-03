package com.cursosandroidant.auth

enum class AuthEvent {
    //Success
    USER_EXIST,
    //fail
    NOT_USER_EXIST,
    EMTY_EMAIL,
    EMTY_PASSWORD,
    EMTY_FORM,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,
    NULL_EMAIL,
    NULL_PASSWORD
}