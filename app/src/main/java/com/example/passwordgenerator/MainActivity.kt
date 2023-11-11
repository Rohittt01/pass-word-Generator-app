package com.example.passwordgenerator
import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var website = findViewById<EditText>(R.id.etWebsite)
        var passwordEditText = findViewById<EditText>(R.id.etPass)
        var btnGp = findViewById<Button>(R.id.btnGeneratePass)

        fun generatePassword(length: Int): String {
            val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*"
            return (1..length)
                .map { charset[Random.nextInt(0, charset.length)] }
                .joinToString("")
        }

        btnGp.setOnClickListener {
            if(website.text.isNotEmpty()){
                val generatedPassword = generatePassword(10)
                passwordEditText.text = Editable.Factory.getInstance().newEditable(generatedPassword)
            }
        }
    }
}
