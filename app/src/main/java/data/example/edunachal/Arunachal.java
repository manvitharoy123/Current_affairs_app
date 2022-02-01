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

public class Arunachal extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "Who succeeded Dorjee Khandu as Arunachal Pradesh’s chief minister?",
            "Which of the following rivers flows through Arunachal Pradesh?",
            "Which country is to the west of Arunachal Pradesh?",
            "Which country refers to Arunachal Pradesh as South Tibet?",
            "When was Arunachal Pradesh separated from Assam?",
            "Which line separates Arunachal Pradesh from Tibet?",
            "Which is the capital of Arunachal Pradesh?",
            "What is the area of Arunachal Pradesh?",
            "Which is the highest point in Arunachal Pradesh?",
            "How was Arunachal Pradesh formerly known?"
    };
    String answers[] = {"Nabam Tuki"," Brahmaputra","Bhutan","China","1972","McMahon Line","Itanagar","32,333 sq. mi.","Kangto","North East Frontier Agency"};
    String opt[] = {
            "Tarun Gogoi","Rishang Keishing","S. C. Jamir","Nabam Tuki",
            "Ganges"," Brahmaputra","Indus","Cauvery",
            "Siam","Bhutan","Burma","Laos",
            "Australia","Indonesia","Philippines","China",
            "2000","1956","1948","1972",
            "Curzon Line","Durand Line","McMahon Line","Maginot Line",
            "Pasighat","Deomali","Tezpur","Itanagar",
            "28,974 sq. mi.","32,333 sq. mi.","56,123 sq. mi.","44,896 sq. mi.",
            "Dhavalagiri","Godwin Austin","Kangto","Namcha Barwa",
            "PEPSU","Coorg","North East Frontier Agency","North West Frontier Province"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arunachal);

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
                    Intent in = new Intent(getApplicationContext(),ArunachalAnswers.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ArunachalAnswers.class);
                startActivity(intent);
            }
        });
    }
}