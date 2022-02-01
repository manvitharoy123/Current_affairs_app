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

public class affairs extends AppCompatActivity {


    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "The Environment Ministry recently released a National action plan for conservation of which species?",
            "What was ‘IN FAC T-81’, which was seen in the news recently?",
            "As per the ‘India Justice Report’, which state has employed most women in its police force?",
            "Which tournament would be conducted this year by the BCCI in place of Ranji Trophy?",
            "As per a recent research, by what percentage the number of oceanic sharks and rays have declined in Indian Ocean?",
            "Which disease is also called as the ‘Hansen’s’ disease?",
            "Arun Hydropower Project, which was making news recently, is being constructed in which country?",
            "According to the WHO, which country has the highest number of new Leprosy cases in the world annually?",
            "‘Neptune Declaration’, which was seen in the news recently, is associated with which sector?",
            "As per the Budget 2021-22, what is the estimated Fiscal Deficit for the current financial year?"
    };
    String answers[] = {"Marine Turtle","Naval Craft","Bihar","Vijay Hazare Trophy","84.7%","Leprosy","Nepal","India","Maritime","9.5%"};
    String opt[] = {
            "Marine Turtle","Great Indian Bustard","Brahmaputra Dolphin","Black Buck",
            "Covid vaccine candidate","Naval Craft","Super computer","Virtual Intelligence tool",
            "Kerala","Bihar","West Bengal","Karnataka",
            "Anna Hazare Trophy","Sachin Trophy","Vijay Hazare Trophy","Seema Roy Trophy",
            "15.3%","26.4%","39.7%","84.7%",
            "Cholera","Polio","Leprosy","Cancer",
            "India","Nepal","Bangladesh","Bhutan",
            "China","Pakisthan","India","Indonesia",
            "Aviation","Migrant Labourers","Maritime","Sports",
            "9.5%","7.0%","4.0%","2.0%"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affairs);

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
                    Intent in = new Intent(getApplicationContext(),affairsanswers.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),affairsanswers.class);
                startActivity(intent);
            }
        });
    }
}