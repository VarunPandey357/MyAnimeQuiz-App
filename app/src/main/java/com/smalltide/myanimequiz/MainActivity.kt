package com.smalltide.myanimequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.smalltide.myanimequiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnStart?.setOnClickListener {
            if (binding?.etName?.text.toString().isEmpty()){
                Toast.makeText(this,"Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@MainActivity, QuizQuestionsActivity::class.java)
                //Passing data through intent
                intent.putExtra(Constants.USER_NAME, binding?.etName?.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}