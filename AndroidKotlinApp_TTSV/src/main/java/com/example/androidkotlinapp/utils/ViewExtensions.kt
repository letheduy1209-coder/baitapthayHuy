package com.example.androidkotlinapp.utils

import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.Toast

// 1. Extension Functions cho View
fun View.show() { visibility = View.VISIBLE }
fun View.gone() { visibility = View.GONE }
fun View.invisible() { visibility = View.INVISIBLE }

// 2. Extension Function cho Context hiển thị Toast
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

// 3. Extension Function cho EditText cắt khoảng trắng
fun EditText.trimmedText(): String = text.toString().trim()

// 4. Extension Function quy đổi xếp loại học lực cho Double
fun Double.toAcademicRanking(): String = when {
    this >= 3.6 -> "Xuất sắc (Excellent)"
    this >= 3.2 -> "Giỏi (Very Good)"
    this >= 2.5 -> "Khá (Good)"
    this >= 2.0 -> "Trung bình (Average)"
    this >= 1.0 -> "Yếu (Weak)"
    else -> "Kém (Poor)"
}