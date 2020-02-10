package com.example.quizz_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button submit = (Button) findViewById(R.id.score_submit_Button);
        submit.setOnClickListener(submitButtonOnClickListener);

    }

    /**
     * This methods checks the question1
     */

    private void checkQuestion1() {

        RadioButton radioButton_Q1_1 = (RadioButton) findViewById(R.id.rb_Q1_option1);
        boolean isradioButtonOneChecked = radioButton_Q1_1.isChecked();
        if (isradioButtonOneChecked) {
            score++;
        } else {
            score = score + 0;
        }
    }

    /**
     * This methods checks the question2
     */

    private void checkQuestion2() {

        CheckBox checkBox_Q2_1 = (CheckBox) findViewById(R.id.cb_Q2_option1);
        CheckBox checkBox_Q2_2 = (CheckBox) findViewById(R.id.cb_Q2_option2);
        CheckBox checkBox_Q3_3 = (CheckBox) findViewById(R.id.cb_Q2_option3);
        boolean isCheckBox1Checked = checkBox_Q2_1.isChecked();
        boolean isCheckBox2Checked = checkBox_Q2_2.isChecked();
        boolean isCheckBox3Checked = checkBox_Q3_3.isChecked();

        if (isCheckBox1Checked && isCheckBox2Checked && !isCheckBox3Checked) {
            score++;
        }
    }

    /**
     *This methods checks the question3
     */

    private String getAnswerforQ3ByUserInput() {
        TextView textViewQuestion3 = (TextView) findViewById(R.id.q3_edit_Text);
        String text = textViewQuestion3.getText().toString();
        return text;

    }

    private void checkQuestion3() {
        String text = getAnswerforQ3ByUserInput();
        if (text.trim().equalsIgnoreCase("5 Sec")) {
            score++;
        }

    }

    /**
     *This methods checks the question4
     */

    private void checkQuestion4() {
        RadioButton radioButton_Q4_1 = (RadioButton) findViewById(R.id.rb_Q4_option1);
        RadioButton radioButton_Q4_2 = (RadioButton) findViewById(R.id.rb_Q4_option2);
        boolean isRadioButton1checked = radioButton_Q4_1.isChecked();
        if (radioButton_Q4_1.isChecked()) {
            score++;
        } else {
            score = score + 0;
        }
    }

    /**
     * This methods checks the question5
     */

    private void checkQuestion5() {
        CheckBox checkBox_Q5_1 = (CheckBox) findViewById(R.id.cb_Q5_option1);
        CheckBox checkBox_Q5_2 = (CheckBox) findViewById(R.id.cb_Q5_option2);
        CheckBox checkBox_Q5_3 = (CheckBox) findViewById(R.id.cb_Q5_option3);
        boolean isCheckBoxOneChecked = checkBox_Q5_1.isChecked();
        boolean isCheckBoxTwoChecked = checkBox_Q5_2.isChecked();
        boolean isCheckBoxThreeChecked = checkBox_Q5_3.isChecked();

        if (isCheckBoxOneChecked && isCheckBoxTwoChecked && !isCheckBoxThreeChecked) {
            score++;
        }

    }

    /**
     *This methods checks the all the Questiond
     */

    private void allQuestionsCheck() {
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();
    }

    /**
     * This methods resets the score to zero
     */

    public void resetscore() {
        score = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            allQuestionsCheck();
            Toast.makeText(MainActivity.this, "Your total score :" + +score + "/5", Toast.LENGTH_LONG).show();
            resetscore();

        }
    };
}
