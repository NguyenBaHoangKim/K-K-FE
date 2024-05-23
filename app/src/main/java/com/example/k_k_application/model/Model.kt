package com.example.k_k_application.model

import android.graphics.Bitmap
import java.sql.Blob
import java.util.Base64

data class User(
    val id: Long,
    val username: String,
    val email: String,
    val password: String,
    val avatarBytes: String ?= null
)

data class UserStr(
    val id: Long,
    val username: String,
    val avatar: String
)
data class UserRes(
    val id: Long,
    val username: String,
    val email: String,
    val password: String,
    val avatar: Blob
)

data class Status(
    val statusId: Long,
    val userId: Long,
    val avt: String,
    val username: String,
    val status: String,
    val img: String
)

data class StatusResp(
    val statusId: Long,
    val avt: String,
    val username: String,
    val status: String,
    val img: String
)
