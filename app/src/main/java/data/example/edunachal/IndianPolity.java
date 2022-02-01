package data.example.edunachal;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edunachal.R;

public class IndianPolity extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Union Budget of India is presented by whom and in which house/ houses of the Parliament?",
            "Who among the following presented Union Budget maximum number of times?",
            "Who among the following presented the first budget (interim) of Independent India?",
            "Which of the following statements is correct about the chairperson of Monetary Policy Committee (MPC)?",
            "Which of the following was the first paper currency issued by RBI?",
            "What is the equity of Reserve bank of India in National Housing Bank ?",
            "Which of the following organizations provides Buffer Stock Financing Facility ?",
            "Which among the following is a correct definition of fiscal deficit?",
            "Who among the following are the beneficiaries of Ways and Means Advances (WMA) facility of Reserve Bank of India?",
            "Many a times we read in the newspapers that credit creation by Banks increases the Money supply. From the following given options, bring out the one, upon which credit creation by banks does not depend?"
    };
    String answers[] = {"Finance Minister of India; Lok Sabha","Morarji Desai","R K Shanmukham Chetty","RBI Governor is the ex officio Chairperson of the committee","Rs 5-Note","100%","International Monetary Fund","Excess of Govt.’s disbursement comprising current and capital expenditures over its current receipts","State Governments","Financial Literacy"};
    String opt[] = {
            "Finance Minister of India; Lok Sabha","Prime Minister of India; Rajya Sabha","Cabinet Secretary; Both Lok Sabha and Rajya Sabha","President of India; in joint session of Parliament",
            "P. Chidambaram","R K Shanmukham Chetty","Pranav Mukherjee","Morarji Desai",
            "Manmohan Singh","Jawaharlal Nehru","R K Shanmukham Chetty","N.D. Tiwari",
            "The chairperson of the committee is appointed by the RBI Governor","RBI Governor is the ex officio Chairperson of the committee","Finance Minister is the ex-officio chairperson of the committee","The Chairperson of the committee is appointed by the Finance Minister",
            "Rs 1-Note","Rs 2-note","Rs 5-Note","Rs 100-note",
            "49%","50%","75%","100%",
            "Reserve Bank of India","Asian Development Bank","International Monetary Fund","World Bank",
            "The gap between projected or estimated GDP and actual GDP","The total value of currency notes issued and currency actual in circulation","The gap between actual borrowings of government of India and expected expenditures as per budget provisions","Excess of Govt.’s disbursement comprising current and capital expenditures over its current receipts",
            "Commercial Banks","Regional Rural banks","State Governments","Authorized Dealers of Foreign Exchanges",
            "Demand & supply Conditions","Financial Literacy","Credit control Policy of Reserve bank of India","Liquidity of the banks"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_polity);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),PolityAnswers.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PolityAnswers.class);
                startActivity(intent);
            }
        });
    }
}