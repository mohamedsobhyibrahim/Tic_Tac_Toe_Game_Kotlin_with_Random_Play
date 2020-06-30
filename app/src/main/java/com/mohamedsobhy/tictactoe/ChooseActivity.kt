package com.mohamedsobhy.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        oneButton.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java).apply {
                putExtra("1", "1")
            }
            startActivity(intent)
        }

        twoButton.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java).apply {
                putExtra("1", "2")
            }
            startActivity(intent)
        }
    }
}