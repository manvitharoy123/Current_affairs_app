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

public class history extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The Battle of Plassey was fought in",
            "Under Akbar, the Mir Bakshi was required to look after",
            "Todar Mal was associated with",
            "The Saka Era was founded by ",
            "Upanishads are books on",
            "Who first imposed Jizya Tax in India?",
            "Who of the following was a contemporary of Gautama Buddha?",
            "Who translated Ramayana into Persian?",
            "Gandhara school of art came into existence in",
            "The word Gotra occurs for the first time in"
    };



    String answers[] = {"1757","military affairs","finance","Kanishka","Philosophy","Qutb-ud-din Aibak","Vardhaman Mahavira","Abdul Fazi","Mahayana sect","Rigveda"};
    String opt[] = {
            "1757","1782","1748","1764",
            "military affairs","the state treasury","the royal household","the land revenue system",
            "music","literature","finance","law",
            "Kadphises I","Kanishka","Alexander","Menander",
            "Religion","Yoga","Law","Philosophy",
            "Allaudin khilji","Aurangzeb","Mohammad Bin Qasim","Qutb-ud-din Aibak",
            "Bhadrabahu","Chandragupta Maurya","Parsvanath","Vardhaman Mahavira",
            "Abdul Fazi","Badauni","Isar Das","Abdul Latif",
            "Hinayana sect","Mahayana sect","Vaishanava sect","Shaiva sect",
            "Rigveda","Samaveda","Yajurveda","Atharvaveda"};
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

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
                    Intent in = new Intent(getApplicationContext(),historyanswers.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),historyanswers.class);
                startActivity(intent);
            }
        });
    }
}