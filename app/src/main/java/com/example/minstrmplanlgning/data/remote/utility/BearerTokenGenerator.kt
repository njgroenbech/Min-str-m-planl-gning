package com.example.minstrmplanlgning.data.remote.utility

import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun generateBearerToken(apiKey: String, apiSecret: String): String {
    // Step 1: HMAC-SHA256 hash of API key using API secret
    val secretKeySpec = SecretKeySpec(apiSecret.toByteArray(Charsets.UTF_8), "HmacSHA256")
    val mac = Mac.getInstance("HmacSHA256")
    mac.init(secretKeySpec)
    val hash = mac.doFinal(apiKey.toByteArray(Charsets.UTF_8))

    // Step 2: Base64 encode the hash
    val base64Hash = Base64.getEncoder().encodeToString(hash)

    // Step 3: Concatenate API key and base64 hash with colon
    val combined = "$apiKey:$base64Hash"

    // Step 4: Base64 encode the combined string
    val finalToken = Base64.getEncoder().encodeToString(combined.toByteArray(Charsets.UTF_8))

    // Step 5: Return Bearer token string
    return "Bearer $finalToken"
}







