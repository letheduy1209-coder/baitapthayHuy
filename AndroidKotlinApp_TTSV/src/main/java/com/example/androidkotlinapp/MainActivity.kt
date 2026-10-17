package com.example.androidkotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlinapp.databinding.ActivityMainBinding
import com.example.androidkotlinapp.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bắt sự kiện click Button -> Thay đổi nội dung TextView
        binding.btnSubmit.setOnClickListener {
            val name = binding.edtFullName.trimmedText()
            val gpa = binding.edtGpaScore.trimmedText().toDoubleOrNull()

            // Validate dữ liệu đầu vào
            if (name.isEmpty()) {
                binding.edtFullName.error = "Vui lòng nhập họ tên"
                return@setOnClickListener
            }

            if (gpa == null || gpa !in 0.0..4.0) {
                binding.edtGpaScore.error = "GPA phải từ 0.0 đến 4.0"
                return@setOnClickListener
            }

            val gender = if (binding.rbMale.isChecked) "Nam" else "Nữ"
            val isNotiEnabled = if (binding.swNotification.isChecked) "Đã bật" else "Đã tắt"

            // Thay đổi nội dung trực tiếp trên TextView (tvDisplayResult)
            binding.tvDisplayResult.text = """
                === KẾT QUẢ ĐÃ THAY ĐỔI TRÊN TEXTVIEW ===
                • Họ tên: $name
                • Giới tính: $gender
                • Điểm GPA: $gpa (${gpa.toAcademicRanking()})
                • Thông báo Email: $isNotiEnabled
                • Cập nhật lúc: System OK!
            """.trimIndent()

            toast("Đã cập nhật TextView thành công!")
        }
    }
}