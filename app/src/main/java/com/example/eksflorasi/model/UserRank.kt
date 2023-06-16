package com.example.eksflorasi.model

data class UserRank(
    val name: String,
    val points: String,
    val avatarUrl: String,
    val resourceId: Int,
    var rank: Int? = null
)