package com.example.minstrmplanlgning.data.remote.utility

import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun generateBearerToken(apiKey: String, apiSecret: String): String {
    val secretKeySpec = SecretKeySpec(apiSecret.toByteArray(Charsets.UTF_8), "HmacSHA256")
    val mac = Mac.getInstance("HmacSHA256")
    mac.init(secretKeySpec)
    val hash = mac.doFinal(apiKey.toByteArray(Charsets.UTF_8))
    val hexHash = hash.joinToString("") { "%02x".format(it) }
    val combined = "$apiKey:$hexHash"
    return Base64.getEncoder().encodeToString(combined.toByteArray(Charsets.UTF_8))
}
