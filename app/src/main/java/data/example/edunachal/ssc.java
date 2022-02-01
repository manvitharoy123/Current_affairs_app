package data.example.edunachal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.edunachal.R;

public class ssc extends AppCompatActivity {
    ImageView eng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssc);
        eng=findViewById(R.id.engque);
        eng.setOnClickListener(View->{
            Intent intent=new Intent(ssc.this,Pdfrender.class);
            startActivity(intent);
        });
    }


}