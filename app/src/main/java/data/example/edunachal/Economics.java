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

public class Economics extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The Pir Panjal range is located in which of the following states?",
            "Which among the following Island of the Andaman & Nicobar islands contains the only known examples of mud volcanoes in India, called locally as “jalki”?",
            "Cooch Behar in West Bengal is famous for which among the following industries?",
            "The Mathabhanga river is treated as an international border between which among the following countries ?",
            "Where is located the headquarters of the North East Zone Cultural Centre ?",
            "At which among the following places, India’s First steel factory was established?",
            "Which among the following plateaus in India lie between Aravali & Vindhya region?",
            "Which among the following is India’s deepest landlocked and protected port?",
            "Which of the following river is known as padma when enters Bangladesh?",
            "In which of the following areas kanikar and Yurva tribes are found in India?"
    };
    String answers[] = {"Jammu and Kashmir","Baratang Island","Silk Industry","India Bangladesh","Dimapur","Burnpur","Malwa Plateau","Vishakhapatnam","Ganga","South India"};
    String opt[] = {
            "Arunachal Pradesh","Jammu and Kashmir","Punjab","Uttarakhand",
            "Baratang Island","Barren Island","Car Nicobar","Havelock Island",
            "Cotton Cloth Industry","Silk Industry","Petroleum Industry","Glass Industry",
            "India Nepal","India Bangladesh","India Myanmmar","India Srilanka",
            "Guwahati","Itanagar","Aizawl","Dimapur",
            "Jamshedpur","Durgapur","Burnpur","Bhilai",
            "Chota Nagpur Plateau","Malwa Plateau","Deccan Plateau","None of the above",
            "Vishakhapatnam","Chennai","Paradeep","Kandla",
            "Brahmputra","Ganga","Teesta","Mahanadi River",
            "North India","North East India","Central India","South India"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economics);

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
                    Intent in = new Intent(getApplicationContext(),EconomicsAnswers.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EconomicsAnswers.class);
                startActivity(intent);
            }
        });
    }
}