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

        // Sự kiện khi bấm nút "Xác Nhận Thông Tin"
        binding.btnSubmit.setOnClickListener {
            val name = binding.edtFullName.trimmedText()
            val gpa = binding.edtGpaScore.trimmedText().toDoubleOrNull()

            if (name.isEmpty()) {
                binding.edtFullName.error = "Vui lòng nhập họ tên"
                return@setOnClickListener
            }

            if (gpa == null || gpa !in 0.0..4.0) {
                binding.edtGpaScore.error = "GPA phải từ 0.0 đến 4.0"
                return@setOnClickListener
            }

            // Lấy giá trị từ RadioButton (Giới tính)
            val gender = if (binding.rbMale.isChecked) "Nam" else "Nữ"

            // Lấy trạng thái từ Switch
            val isNotiEnabled = if (binding.swNotification.isChecked) "Đã bật" else "Đã tắt"

            // Hiển thị thông tin tổng hợp lên TextView kết quả
            binding.tvDisplayResult.text = """
                === THÔNG TIN ĐÃ XÁC NHẬN ===
                • Họ tên: $name
                • Giới tính: $gender
                • Điểm GPA: $gpa (${gpa.toAcademicRanking()})
                • Nhận thông báo: $isNotiEnabled
            """.trimIndent()

            toast("Đã xử lý thông tin thành công!")
        }
    }
}