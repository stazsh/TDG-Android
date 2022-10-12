package com.thedhobighat

data class LoginResponse(
    var success: Boolean,
    var message: String,
    var jwt: String,
    var jwt_refresh: String
)