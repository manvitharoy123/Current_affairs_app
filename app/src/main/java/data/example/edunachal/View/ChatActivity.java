package data.example.edunachal.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edunachal.R;


public class ChatActivity extends AppCompatActivity {
    private Button openTeachersActivityBtn,openUploadActivityBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_image );

        openTeachersActivityBtn = findViewById ( R.id.openTeachersActivityBtn );
        openUploadActivityBtn = findViewById ( R.id.openUploadActivityBtn );

        openTeachersActivityBtn.setOnClickListener(view -> {
            Intent i = new Intent(ChatActivity.this, ItemsActivity.class);
            startActivity(i);
        });
        openUploadActivityBtn.setOnClickListener(view -> {
            Intent i = new Intent(ChatActivity.this, UploadActivity.class);
            startActivity(i);
        });

    }


}
