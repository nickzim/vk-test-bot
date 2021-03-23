package com.nickzim.domain.responce

data class Response(
        val response: String?,
        val error: Error? = null
)
