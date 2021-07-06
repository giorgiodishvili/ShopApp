package com.android.shopapp.extensions

fun String.isEmail() = android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
