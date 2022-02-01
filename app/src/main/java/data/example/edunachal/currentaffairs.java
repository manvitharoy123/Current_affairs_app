package data.example.edunachal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edunachal.R;

public class currentaffairs extends AppCompatActivity {
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
        setContentView(R.layout.activity_currentaffairs);
        getSupportActionBar().hide();
        daily=findViewById(R.id.daily);
        daily.setOnClickListener(View->{
            Intent intent3=new Intent(currentaffairs.this,UniversalCurrentAffairs.class);
            startActivity(intent3);
        });

        button9= findViewById(R.id.button9);
        final ImageView pd=findViewById(R.id.pd);
        pd.setOnClickListener(View->{
            Intent intent2=new Intent(currentaffairs.this,PdfActivity.class);
            startActivity(intent2);
        });
        final ImageView live=findViewById(R.id.live);
        live.setOnClickListener(View->{
            Intent intent=new Intent(currentaffairs.this,classe.class);
            startActivity(intent);
        });

        pdf=findViewById(R.id.pdf);
        pdf.setOnClickListener(view->{
            Intent intent=new Intent(currentaffairs.this,DiscussionChats.class);
            startActivity(intent);
        });
    }
}