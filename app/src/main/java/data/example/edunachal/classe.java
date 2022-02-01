package data.example.edunachal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.edunachal.R;

import data.example.edunachal.View.ItemsActivity;

public class classe extends AppCompatActivity {
    Button button9;
    Button button10;
    Button chat;
    ImageView pdf;
    ImageView daily;
    Button upload;
    ImageView gat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe);
        getSupportActionBar().hide();
        daily=findViewById(R.id.daily);
        daily.setOnClickListener(View->{
            Intent intent3=new Intent(classe.this, ItemsActivity.class);
            startActivity(intent3);
        });
        gat=findViewById(R.id.quiz1);
        gat.setOnClickListener(View->{
            Intent intent3=new Intent(classe.this,time.class);
            startActivity(intent3);
        });

        button9= findViewById(R.id.button9);
        final ImageView pd=findViewById(R.id.pd);
        pd.setOnClickListener(View->{
            Intent intent2=new Intent(classe.this,You.class);
            startActivity(intent2);
        });
        final ImageView live=findViewById(R.id.live);
        live.setOnClickListener(View->{
            Intent intent=new Intent(classe.this,LiveClasses.class);
            startActivity(intent);
        });
    }
}