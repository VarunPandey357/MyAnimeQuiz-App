package com.smalltide.myanimequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smalltide.myanimequiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private var binding: ActivityResultBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//       //Todo: connect to each view in the layout through its id
//        val tvName: TextView = findViewById(R.id.tv_name)
//        val tvScore:TextView = findViewById(R.id.tv_score)
//        val btnFinish:Button = findViewById(R.id.btn_finish)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        binding?.tvName?.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        binding?.tvScore?.text = "Your Score is $correctAnswers out of $totalQuestions."

        binding?.btnFinish?.setOnClickListener {
            //
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }


}