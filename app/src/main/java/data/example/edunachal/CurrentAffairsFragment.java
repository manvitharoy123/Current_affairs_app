package data.example.edunachal;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edunachal.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.ServerValues;
import java.util.ArrayList;
import java.util.List;

public class CurrentAffairsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    List<CurrentAffairsModel> currentAffairsModels;
    private String mParam1;
    private String mParam2;
    ProgressBar progressBar;

    public static CurrentAffairsFragment newInstance(String param1, String param2) {
        CurrentAffairsFragment fragment = new CurrentAffairsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_current_affairs, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar3);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        FirebaseDatabase.getInstance().getReference().child("current_affairs").child("universal").child(getArguments().getString("date")).orderByChild(ServerValues.NAME_OP_TIMESTAMP).addListenerForSingleValueEvent(new ValueEventListener() {
            /* class CurrentAffairsFragment.AnonymousClass1 */

            @SuppressLint("WrongConstant")
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    CurrentAffairsFragment.this.currentAffairsModels = new ArrayList();
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        if (!ds.getKey().equals(ServerValues.NAME_OP_TIMESTAMP)) {
                            CurrentAffairsFragment.this.currentAffairsModels.add((CurrentAffairsModel) ds.getValue(CurrentAffairsModel.class));
                        }
                    }
                    recyclerView.setAdapter(new MyRecyclerViewAdaptor(view.getContext(), CurrentAffairsFragment.this.currentAffairsModels));
                    CurrentAffairsFragment.this.progressBar.setVisibility(4);
                    return;
                }
                Toast.makeText(view.getContext(), "No data found", 0).show();
                CurrentAffairsFragment.this.progressBar.setVisibility(4);
            }

            @SuppressLint("WrongConstant")
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
                Toast.makeText(view.getContext(), "Error Occured", 0).show();
                CurrentAffairsFragment.this.progressBar.setVisibility(4);
            }
        });
        return view;
    }
}