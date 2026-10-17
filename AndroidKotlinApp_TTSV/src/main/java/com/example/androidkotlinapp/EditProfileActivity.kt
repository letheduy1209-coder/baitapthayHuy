package com.example.androidkotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlinapp.databinding.ActivityEditProfileBinding
import com.example.androidkotlinapp.model.Student
import com.example.androidkotlinapp.utils.toAcademicRanking

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận dữ liệu từ Intent Extra
        val id = intent.getStringExtra("EXTRA_STUDENT_ID") ?: "Chưa có MSSV"
        val name = intent.getStringExtra("EXTRA_STUDENT_NAME") ?: ""
        val gpa = intent.getDoubleExtra("EXTRA_STUDENT_GPA", 0.0)

        @Suppress("DEPRECATION")
        val student = intent.getSerializableExtra("EXTRA_STUDENT_OBJECT") as? Student

        // Hiển thị lên giao diện
        binding.tvStudentId.text = "MSSV từ Intent: $id"
        binding.edtName.setText(name)
        binding.edtGpa.setText(gpa.toString())

        binding.tvReceivedInfo.text = """
            === DỮ LIỆU NHẬN TỪ EXPLICIT INTENT ===
            • Extra String (ID): $id
            • Extra String (Name): $name
            • Extra Double (GPA): $gpa
            • Extra Object (Student): ${student?.name ?: "N/A"} (${student?.className})
            • Xếp loại học lực: ${gpa.toAcademicRanking()}
        """.trimIndent()

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}