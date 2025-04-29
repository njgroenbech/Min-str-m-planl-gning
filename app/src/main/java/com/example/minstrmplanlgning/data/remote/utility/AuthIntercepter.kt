package com.example.minstrmplanlgning.data.remote.utility

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val bearerToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $bearerToken")
            .build()
        return chain.proceed(request)
    }
}