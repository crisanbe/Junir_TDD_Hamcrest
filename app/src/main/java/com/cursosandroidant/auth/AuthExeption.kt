package com.cursosandroidant.auth

import java.lang.Exception

class AuthExeption(val authEvent: AuthEvent, msg: String?): Exception(msg) {
}