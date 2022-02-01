package data.example.edunachal;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.edunachal.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.ServerValues;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UniversalCurrentAffairs extends AppCompatActivity {
    List<String> allDates;
    DatabaseReference databaseReference;
    List<String> dateList;
    ProgressBar progressBar;
    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager2 viewPager2;
    ViewPagerAdaptor viewPagerAdaptor;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal_current_affairs);
        this.progressBar = findViewById(R.id.progressBar2);
        this.viewPager2 = findViewById(R.id.viewPager);
        this.toolbar = (Toolbar) findViewById(R.id.appBarCurrent);
        getSupportActionBar().hide();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Current Affairs");
        this.tabLayout = findViewById(R.id.tabLayout);
        this.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            /* class UniversalCurrentAffairs.AnonymousClass1 */

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                UniversalCurrentAffairs.this.tabLayout.selectTab(UniversalCurrentAffairs.this.tabLayout.getTabAt(position), true);
            }
        });
        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            /* class UniversalCurrentAffairs.AnonymousClass2 */

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                UniversalCurrentAffairs.this.viewPager2.setCurrentItem(tab.getPosition(), true);
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        DatabaseReference child = FirebaseDatabase.getInstance().getReference().child("current_affairs").child("universal");
        this.databaseReference = child;
        child.orderByChild(ServerValues.NAME_OP_TIMESTAMP).limitToLast(7).addListenerForSingleValueEvent(new ValueEventListener() {
            /* class UniversalCurrentAffairs.AnonymousClass3 */

            @SuppressLint("WrongConstant")
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                UniversalCurrentAffairs.this.dateList = new ArrayList();
                if (snapshot.exists()) {
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        UniversalCurrentAffairs.this.dateList.add(ds.getKey());
                    }
                    Collections.reverse(UniversalCurrentAffairs.this.dateList);
                    for (String mDate : UniversalCurrentAffairs.this.dateList) {
                        UniversalCurrentAffairs.this.tabLayout.addTab(UniversalCurrentAffairs.this.tabLayout.newTab().setText(mDate.replace(" ", "/")));
                    }
                    UniversalCurrentAffairs universalCurrentAffairs = UniversalCurrentAffairs.this;
                    UniversalCurrentAffairs universalCurrentAffairs2 = UniversalCurrentAffairs.this;
                    universalCurrentAffairs.viewPagerAdaptor = new ViewPagerAdaptor(universalCurrentAffairs2, universalCurrentAffairs2.dateList);
                    UniversalCurrentAffairs.this.viewPager2.setAdapter(UniversalCurrentAffairs.this.viewPagerAdaptor);
                } else {
                    Toast.makeText(UniversalCurrentAffairs.this, "No data found", 0).show();
                }
                UniversalCurrentAffairs.this.progressBar.setVisibility(4);
            }

            @SuppressLint("WrongConstant")
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
                Toast.makeText(UniversalCurrentAffairs.this, "Error occurred", 0).show();
                UniversalCurrentAffairs.this.progressBar.setVisibility(4);
            }
        });
        this.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            /* class UniversalCurrentAffairs.AnonymousClass4 */

            @SuppressLint("WrongConstant")
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() != R.id.calendar) {
                    return true;
                }
                UniversalCurrentAffairs.this.allDates = new ArrayList();
                UniversalCurrentAffairs.this.progressBar.setVisibility(0);
                UniversalCurrentAffairs.this.databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    /* class UniversalCurrentAffairs.AnonymousClass4.AnonymousClass1 */

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            UniversalCurrentAffairs.this.allDates = new ArrayList();
                            for (DataSnapshot ds : snapshot.getChildren()) {
                                UniversalCurrentAffairs.this.allDates.add(ds.getKey());
                            }
                            Calendar calendar = Calendar.getInstance();
                            DatePickerDialog datePickerDialog = new DatePickerDialog(UniversalCurrentAffairs.this, new DatePickerDialog.OnDateSetListener() {
                                /* class UniversalCurrentAffairs.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                    String date = dayOfMonth + " " + (month + 1) + " " + year;
                                    if (UniversalCurrentAffairs.this.allDates.contains(new String(date))) {
                                        Intent intent = new Intent(UniversalCurrentAffairs.this, DisplayCurrentAffairs.class);
                                        intent.putExtra("date", date);
                                        UniversalCurrentAffairs.this.startActivity(intent);
                                        return;
                                    }
                                    Toast.makeText(UniversalCurrentAffairs.this, "No current affairs available for this date", 0).show();
                                }
                            }, calendar.get(1), calendar.get(2), calendar.get(5));
                            datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                            datePickerDialog.show();
                        }
                        UniversalCurrentAffairs.this.progressBar.setVisibility(4);
                    }

                    @Override // com.google.firebase.database.ValueEventListener
                    public void onCancelled(DatabaseError error) {
                        UniversalCurrentAffairs.this.progressBar.setVisibility(4);
                        Toast.makeText(UniversalCurrentAffairs.this, "An Error Occured", 0).show();
                    }
                });
                return true;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}