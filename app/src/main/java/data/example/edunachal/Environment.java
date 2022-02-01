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

public class Environment extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Which of the following facts are incorrect?",
            "Areas that are under the influence of DDT may observe a decline in the population of birds. This is due to the fact that",
            "Measuring BOD (biological oxygen demand) is primarily used for",
            "Cosmic rays, such as gamma rays are a source of",
            "The primary agenda of the Kyoto protocol is ",
            "The presence of _________ in a water body is an indicator of water pollution.",
            "Eggshells of birds become unusually thin when exposed to the pesticides in their environment. The protein that gets affected is ________",
            "Lichens are good bioindicators for ",
            "A moth having a speckled wing, able to blend into its background due to its dark colouration is called",
            "Carbon dioxide is primarily called a greenhouse gas because"
    };
    String answers[] = {"Ozone is harmless to breathe","The eggs did not hatch","Estimating the quantity of organic matter in sewage water","Radiation pollution","Control anthropogenic sources of greenhouse gases","E.Coli","Calmodulin","Water and air pollution","Industrial melanism","Traps heat"};
    String opt[] = {
            "Global warming is the rise in the average temperature of the earth’s climate system","Eutrophication is observed in water bodies","The greenhouse effect is a natural phenomenon","Ozone is harmless to breathe",
            "Birds stopped laying eggs altogether","The eggs did not hatch","Predation of the eggs increased","none",
            "Estimating the types of microbes","Determine the level of dissolved oxygen","Estimating the quantity of organic matter in sewage water","none",
            "Soil Pollution","Noise Pollution","Thermal Pollution","Radiation pollution",
            "Regulation of hazardous wastes","Regulate the production of nuclear energy","Control anthropogenic sources of greenhouse gases","none",
            "Zygosporangium","E.Coli","Deinococcus radiodurans","none",
            "Calmodulin","Cysteine","Serine","none",
            "Environmental radiation","Soil pollution","Water and air pollution","Excess of Govt.’s disbursement comprising current and capital expenditures over its current receipts",
            "Industrial melanism","Adaptation","Predation","Evolution",
            "Traps heat","Traps light","Traps warm currents","none"
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
                    Intent in = new Intent(getApplicationContext(),EnvironmentAnswers.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EnvironmentAnswers.class);
                startActivity(intent);
            }
        });
    }
}