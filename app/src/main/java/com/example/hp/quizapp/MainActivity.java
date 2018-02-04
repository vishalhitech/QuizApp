package com.example.hp.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
    Button mTrueButton;
    Button mFalsebutton;
    TextView mQuestionTextView;
    int mIndex;
    int mQuesion;

    // creating question bank array mQuestionBank with their Correct answer and work as Constructor
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalsebutton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mQuesion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuesion);

        View.OnClickListener myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"True Pressed",Toast.LENGTH_SHORT).show();
                cheakAnswer(true);
                updateQuestion();
            }
        };
        mTrueButton.setOnClickListener(myListener);

        mFalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cheakAnswer(false);
                updateQuestion();
            }
        });
    }

    private void updateQuestion(){
        mIndex = (mIndex + 1) % mQuestionBank.length;
        mQuesion = mQuestionBank[mIndex].getQuestionID();
        mQuestionTextView.setText(mQuesion);
    }

    private void cheakAnswer(boolean userSelection){
        boolean correctAnswer= mQuestionBank[mIndex].isAnswer();

        if(userSelection==correctAnswer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }

}