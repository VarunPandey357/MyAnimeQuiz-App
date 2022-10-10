package com.smalltide.myanimequiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.smalltide.myanimequiz.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: ActivityQuizQuestionsBinding?= null

    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Get the NAME from intent and assign it the variable
        // START
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        // END
        //connect to the view by its id
//        progressBar=findViewById(R.id.progressBar)
//        tvProgress = findViewById(R.id.tv_progress)
//        tvQuestion = findViewById(R.id.tv_question)
//        ivImage = findViewById(R.id.iv_image)
//        tvOptionOne = findViewById(R.id.tv_option_one)
//        tvOptionTwo = findViewById(R.id.tv_option_two)
//        tvOptionThree = findViewById(R.id.tv_option_three)
//        tvOptionFour = findViewById(R.id.tv_option_four)
//        buttonSubmit = findViewById(R.id.btn_submit)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        binding?.tvOptionOne?.setOnClickListener(this)
        binding?.tvOptionTwo?.setOnClickListener(this)
        binding?.tvOptionThree?.setOnClickListener(this)
        binding?.tvOptionFour?.setOnClickListener(this)
        binding?.btnSubmit?.setOnClickListener (this)

    }



    /**
     * A function for setting the question to UI components.
     */
    private fun setQuestion() {

        val question: Question =
            mQuestionsList!![mCurrentPosition - 1] // Getting the question from the list with the help of current position.
        defaultOptionsView()
        if (mCurrentPosition == mQuestionsList!!.size) {
            binding?.btnSubmit?.text = "FINISH"
        } else {
            binding?.btnSubmit?.text = "SUBMIT"
        }
        binding?.progressBar?.progress =
            mCurrentPosition // Setting the current progress in the progressbar using the position of question
        binding?.tvProgress?.text =
            "$mCurrentPosition" + "/" + binding?.progressBar?.max // Setting up the progress text

        // Now set the current question and the options in the UI
        binding?.tvQuestion?.text = question.question
        binding?.ivImage?.setImageResource(question.image)
        binding?.tvOptionOne?.text = question.optionOne
        binding?.tvOptionTwo?.text = question.optionTwo
        binding?.tvOptionThree?.text = question.optionThree
        binding?.tvOptionFour?.text = question.optionFour
    }

    /**
     * A function to set default options view when the new question is loaded or when the answer is reselected.
     */
    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        binding?.tvOptionOne?.let {
            options.add(0, it)
        }
        binding?.tvOptionTwo?.let {
            options.add(1, it)
        }
        binding?.tvOptionThree?.let {
            options.add(2, it)
        }
        binding?.tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tv_option_one -> {
                binding?.tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }

            }

            R.id.tv_option_two -> {
                binding?.tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }

            }

            R.id.tv_option_three -> {
                binding?.tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }

            }

            R.id.tv_option_four -> {
                binding?.tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }

            }
            R.id.btn_submit->{

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                        }
                        else -> {
                            // TODO (Now remove the toast message and launch the result screen which we have created and also pass the user name and score details to it.)
                            // START
                            val intent =
                                Intent(this@QuizQuestionsActivity, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        binding?.btnSubmit?.text = "FINISH"
                    } else {
                        binding?.btnSubmit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }

    /**
     * A function for answer view which is used to highlight the answer is wrong or right.
     */
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                binding?.tvOptionOne?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2 -> {
                binding?.tvOptionTwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3 -> {
                binding?.tvOptionThree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4 -> {
                binding?.tvOptionFour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }
}