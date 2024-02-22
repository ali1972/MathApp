package com.example.shapeapp;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    private TextView num1TV;
    private TextView num2TV;
    private TextView ans1TV;
    private TextView ans2TV;
    private TextView ans3TV;
    private TextView ans4TV;
    private TextView theAnswerTV;
    private Button nextQBtn;

    private int num1;
    private int num2;
    private int correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1TV = findViewById(R.id.num1);
        num2TV = findViewById(R.id.num2);
        ans1TV = findViewById(R.id.ans1);
        ans2TV = findViewById(R.id.ans2);
        ans3TV = findViewById(R.id.ans3);
        ans4TV = findViewById(R.id.ans4);
        theAnswerTV = findViewById(R.id.the_answer);
        nextQBtn = findViewById(R.id.next_q);

        nextQuestion();
        ButtonLis buttonLis = new ButtonLis();
        nextQBtn.setOnClickListener(buttonLis);

//        nextQBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                nextQuestion();
//            }
//        });

    }


    private void nextQuestion(){
        Random rn = new Random();
        theAnswerTV.setText("");
        num1 = rn.nextInt(51);
        num2 = rn.nextInt(51);
        correctAnswer = num1 + num2;
        num1TV.setText(num1+"");
        num2TV.setText(num2+"");
        TextView[] answers = {ans1TV,ans2TV,ans3TV,ans4TV};
        for(int i=0; i<answers.length ; i++)
            answers[i].setText(randomNumber(correctAnswer)+"");



        int correctAnserIndex = (int)(Math.random()*4);
        answers[correctAnserIndex].setText(correctAnswer+"");

        AnswersLis answersLis = new AnswersLis();
        for(int i=0 ; i<answers.length; i++)
            answers[i].setOnClickListener(answersLis);

    }
    private int randomNumber(int n){
        Random rn = new Random();
        int x = rn.nextInt(101);
        while( x == correctAnswer)
            x = rn.nextInt(101);
        return x;
    }
    public class ButtonLis implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            nextQuestion();
        }
    }

    public class AnswersLis implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            TextView tv = (TextView)v;
            String st = tv.getText().toString();
            int num = Integer.parseInt(st);
            if(num == correctAnswer)
                theAnswerTV.setText("Correct!");
            else
                theAnswerTV.setText("Incorrect!");

        }
    }
}