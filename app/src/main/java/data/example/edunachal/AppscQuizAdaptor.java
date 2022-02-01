package data.example.edunachal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edunachal.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AppscQuizAdaptor extends RecyclerView.Adapter<AppscQuizAdaptor.MyViewHolder>{
    List<AppscModelQuiz> appscModelQuizs;
    Context context;
    String extraFlag;

    public AppscQuizAdaptor(List<AppscModelQuiz> appscModelQuizs, Context context, String extraFlag) {
        this.appscModelQuizs = appscModelQuizs;
        this.context = context;
        this.extraFlag = extraFlag;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appsc_quiz_temp,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AppscModelQuiz appscModelQuiz = appscModelQuizs.get(position);
        holder.question.setText(appscModelQuiz.getQuestion());
        holder.option1.setText(appscModelQuiz.getOption1());
        holder.option2.setText(appscModelQuiz.getOption2());
        holder.option3.setText(appscModelQuiz.getOption3());
        holder.option4.setText(appscModelQuiz.getOption4());
        holder.explanation.setText(appscModelQuiz.getExplanation());
    }

    @Override
    public int getItemCount() {
        return appscModelQuizs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        EditText question, month, answer, option1, option2, option3, option4, explanation;
        Button button;
        ImageButton imageButton;
        DatabaseReference databaseReference;
        ProgressBar progressBar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

                    databaseReference = FirebaseDatabase.getInstance().getReference().child("current_affairs").child("appsc");
            progressBar=itemView.findViewById(R.id.progressBar);
            button=itemView.findViewById(R.id.button3);
            question= itemView.findViewById(R.id.editTextTextMultiLine);
            question.setKeyListener(null);
            question.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "You can not edit question now\nYou can delete this and re upload it again", Toast.LENGTH_SHORT).show();
                }
            });
            option1=itemView.findViewById(R.id.editTextTextPersonName);
            option2=itemView.findViewById(R.id.editTextTextPersonName2);
            option3=itemView.findViewById(R.id.editTextTextPersonName3);
            option4=itemView.findViewById(R.id.editTextTextPersonName4);
            explanation=itemView.findViewById(R.id.editTextTextMultiLine2);
        }
    }
}