package com.Refee.RefeeDB

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        val register = findViewById<Button>(R.id.registerB)

        register.setOnClickListener{
            val email = findViewById<EditText>(R.id.email)
            val password = findViewById<EditText>(R.id.password)
            val passagain = findViewById<EditText>(R.id.passagain)

            if(password.text.toString() == passagain.text.toString()){
                auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "회원가입 완료", Toast.LENGTH_LONG).show()
                            finish()
                        } else {
                            Toast.makeText(this, "회원가입 실패", Toast.LENGTH_LONG).show()
                        }
                    }
            }
            else{
                Toast.makeText(this, "비밀번호가 일치하지 않음", Toast.LENGTH_LONG).show()
            }
        }
    }
}