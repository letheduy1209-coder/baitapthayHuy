package com.example.androidkotlinapp.model

import java.io.Serializable

data class Student(
    val id: String,        // Mã số sinh viên (VD: 2415053122208)
    val name: String,      // Họ và tên (VD: Lê Thế Duy)
    val className: String, // Lớp sinh hoạt (VD: 24T2)
    val email: String,     // Địa chỉ email sinh viên
    val gpa: Double        // Điểm trung bình tích lũy (0.0 - 4.0)
) : Serializable {

    val isHonorStudent: Boolean
        get() = gpa >= 3.6
}