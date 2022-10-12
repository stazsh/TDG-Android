package com.thedhobighat

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TdgApi {

    @POST("login")
    suspend fun postCredentials(@Body credentials: LoginCredentials) : Response<LoginResponse>



}