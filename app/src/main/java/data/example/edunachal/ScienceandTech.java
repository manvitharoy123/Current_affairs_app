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

public class ScienceandTech extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The communication satellite of ISRO, GSAT-30 is scheduled to launch aboard which vehicle?",
            "What is the theme of the ‘NIC TechConclave 2020’, organized by the National Informatics Centre (NIC)?",
            "Which country has launched a 4 million pound – ‘Innovation Challenge Fund’ in India?",
            "The cybersecurity project codenamed Dejfa, that was recently making news, belongs to which country?",
            "‘Polymer Electrolyte Membrane fuel cells (PEMFC)’, which was making news recently, is to be deployed in which field?",
            "Which Indian state uses robots to spread awareness on COVID-19 among the public?",
            "Which social-media platform launched ‘Coronavirus Information Hub’ in partnership with WHO, UNICEF and UNDP?",
            "The Department of Science and Technology has released Rs. 1 Crore to a company named ‘Scitech Park’ for manufacturing which product?",
            "‘Nearby Spot’ is an initiative of which technological firm, to provide information on locating local stores that sells essential things?",
            "The ‘COVID-19 Sample Collection Kiosk’ (COVSACK), which was seen in news recently, was developed by the laboratory of which institution?"
    };
    String answers[] = {"Ariane 5","‘Technologies for NextGen Governance’","United Kingdom","Iran","Disaster Management","Kerala","WhatsApp","Air Purifier","Google","Defence Research and Development Organisation"};
    String opt[] = {
            "PSLV C 44","PSLV C 46","PSLV C 47","Ariane 5",
            "‘Technologies for NextGen Governance’","‘Artificial Intelligence For All’","‘Machine Learning For All’","‘AI for e-Governance'",
            "Egypt","Zimbabwe","United Kingdom","Lebanon",
            "Pakistan","Iran","Malaysia","China",
            "Disaster Management","Fuel Conservation","Renewable Energy","Marine Technology",
            "Andhra Pradesh","Telangana","Kerala","Odisha",
            "Twitter","WhatsApp","Instagram","Telegram",
            "Masks","Hand Sanitiser","Air Purifier","Ventilator",
            "Facebook","Google","Amazon","Apple",
            "Defence Research and Development Organisation","Hindustan Aeronautics Limited","Bharat Electronics Limited","Bharat Heavy Electricals Limited"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scienceand_tech);

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
                    Intent in = new Intent(getApplicationContext(),ScienceandTech.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ScienceandTech.class);
                startActivity(intent);
            }
        });
    }
}