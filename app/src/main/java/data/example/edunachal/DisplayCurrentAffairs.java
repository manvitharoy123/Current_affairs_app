package data.example.edunachal;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.edunachal.R;

public class DisplayCurrentAffairs extends AppCompatActivity {
    String date;
    FragmentManager fragmentManager;
    TextView textView;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_current_affairs);
        this.date = getIntent().getStringExtra("date");
        TextView textView2 = (TextView) findViewById(R.id.textView9);
        this.textView = textView2;
        textView2.setText(this.date.replace(" ", "/"));
        Bundle bundle = new Bundle();
        bundle.putString("date", this.date);
        CurrentAffairsFragment currentAffairsFragment = new CurrentAffairsFragment();
        currentAffairsFragment.setArguments(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, currentAffairsFragment);
        fragmentTransaction.commit();
    }
}