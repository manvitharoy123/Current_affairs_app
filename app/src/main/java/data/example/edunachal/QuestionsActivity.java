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

public class QuestionsActivity extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "How many presidents of India so far were elected unopposed?",
            "In which year, first general elections to Lok Sabha were held in India?",
            "In which year, parliament passed the Citizenship Act?",
            "Which among the following has the power to legislate on the matters which are neither in the Union List, nor in the State list nor in the Concurrent list of the Constitution of India?",
            "The Parliament of India is consisted of : ",
            "Which among the following amendment acts is also called as a Mini constitution?",
            "In which schedule of Indian Constitution, the territorial extent of Indian states and union Territories is prescribed?",
            "Which among the following is the most appropriate definition of Political liberty of Citizens of India ?",
            "Which among the following schedules is related to the responsibilities of Municipalities?",
            "Which among the following is a correct statement?"
    };
    String answers[] = {"two","1951","1955","Parliament","Lok Sabha & Rajya Sabha & President","42nd   Amendment  Act 1976","1st","Right  to participate in the government and assume equal opportunity to assume highest office","12th","USA – Supremacy of the constitution ;Britain – Supremacy of the Parliament"};
    String opt[] = {
            "one","two","three","four",
            "1948","1949","1950","1951",
            "1950","1955","1960","1965",
            "Parliament","State Legislatures","Both Statelegislatures and Parliament","Neither  Parliament  nor  State legislature",
            "Lok Sabha & Rajya Sabha","Lok Sabha & Rajya Sabha & President","Lok Sabha, Rajya Sabha, President & Prime Minister","Lok Sabha, Rajya Sabha & Council of Ministers",
            "52nd  Amendment  Act 1985","42nd   Amendment  Act 1976","1st  Amendment  Act 1951","none of these",
            "1st","2nd","3rd","4th",
            "Right  to participate in the government and assume equal opportunity to assume highest office","right to cast vote and participate in the election process","Equal opportunity to freely move in the Political territories of India","none",
            "9th","10th","11th","12th",
            "USA – Supremacy of the constitution ;Britain – Supremacy of the Parliament","Britain – Supremacy of the constitution ;USA – Supremacy of the Parliament","Britain & USA -Supremacy of the constitution","Britain & USA -Supremacy of the Parliament"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);

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
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}