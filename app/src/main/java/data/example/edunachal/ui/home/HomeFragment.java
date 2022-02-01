package data.example.edunachal.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.edunachal.R;

import data.example.edunachal.Bank;
import data.example.edunachal.quizactivity;

public class HomeFragment extends Fragment {

ImageView currentaffairs;
ImageView quiz;
ImageView upsc;
ImageView bank;
ImageView appsc;
ImageView appsb;
ImageView ssc;
ImageView ugc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
      currentaffairs=root.findViewById(R.id.currentaffairs);
      quiz =root.findViewById(R.id.quiz);
      upsc=root.findViewById(R.id.upsc);
      bank=root.findViewById(R.id.Bank);
      appsc=root.findViewById(R.id.appsc);
      appsb=root.findViewById(R.id.appsb);
      ssc=root.findViewById(R.id.ssc);
      ugc=root.findViewById(R.id.ugc);
        currentaffairs.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), data.example.edunachal.currentaffairs.class);
            startActivity(intent);
        });
        quiz.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), quizactivity.class);
            startActivity(intent);
        });
        upsc.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), data.example.edunachal.upsc.class);
            startActivity(intent);
        });
        bank.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), Bank.class);
            startActivity(intent);
        });
        appsc.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), data.example.edunachal.appsc.class);
            startActivity(intent);
        });
        appsb.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), data.example.edunachal.appsb.class);
            startActivity(intent);
        });
        ssc.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), data.example.edunachal.ssc.class);
            startActivity(intent);
        });
        ugc.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(), data.example.edunachal.ugc.class);
            startActivity(intent);
        });
        return root;
    }
}