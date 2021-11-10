package com.example.databasedoit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.databasedoit.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val editText = binding.editText.text.toString()
            val db = DBHelper(this).writableDatabase
            db.execSQL(
                "insert into Todo_TB (todo) values (?)",
                arrayOf<String>(editText)
            )
            db.close()
            finish()
        }
    }
}