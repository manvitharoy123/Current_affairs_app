package data.example.edunachal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edunachal.R;

public class quizactivity extends AppCompatActivity {
Button chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizactivity);
        final Button button8 =findViewById(R.id.button9);
        button8.setOnClickListener(v -> startActivity(new Intent(quizactivity.this, history.class)));
        final Button polity =findViewById(R.id.IndianPolity);
        polity.setOnClickListener(v -> startActivity(new Intent (quizactivity.this,QuizActivity1.class)));
        final Button economics =findViewById(R.id.Economics);
        economics.setOnClickListener(v -> startActivity(new Intent(quizactivity.this,IndianPolity.class)));
        final Button geograohy=findViewById(R.id.Geography);
        geograohy.setOnClickListener(v -> startActivity(new Intent(quizactivity.this,Economics.class)));
final Button gat=findViewById(R.id.gat);
gat.setOnClickListener(View->{
    Intent intent=new Intent(quizactivity.this,currentquiz.class);
    startActivity(intent);
});
        chat=findViewById(R.id.ScienceandTech);
        chat.setOnClickListener(View->{
            Intent intent=new Intent(quizactivity.this,ScienceandTech.class);
            startActivity(intent);
        });
    final Button Environment=findViewById(R.id.Environment);
    Environment.setOnClickListener(View->{
                Intent intent=new Intent(quizactivity.this,Environment.class);
                startActivity(intent);
            }
            );
    final Button maths=findViewById(R.id.Maths);
    maths.setOnClickListener(View->{
        Intent intent=new Intent(quizactivity.this,Maths.class);
        startActivity(intent);
    });
    final Button reasoning=findViewById(R.id.Reasoning);
    reasoning.setOnClickListener(View->{
        Intent intent=new Intent(quizactivity.this,Reasoning.class);
        startActivity(intent);

    });
    final Button english=findViewById(R.id.English);
    english.setOnClickListener(View->{
        Intent intent=new Intent(quizactivity.this,English.class);
        startActivity(intent);
    });
    final Button arunachal=findViewById(R.id.Arunachal);
    arunachal.setOnClickListener(View->{
        Intent intent=new Intent(quizactivity.this,Arunachal.class);
        startActivity(intent);
    });
    final Button affairs=findViewById(R.id.Curre);
    affairs.setOnClickListener(View->{
        Intent intent=new Intent(quizactivity.this,affairs.class);
        startActivity(intent);
    });}
}