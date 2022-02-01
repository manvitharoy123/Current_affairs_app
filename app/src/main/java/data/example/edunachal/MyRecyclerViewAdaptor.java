package data.example.edunachal;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edunachal.R;

import java.util.List;

public class MyRecyclerViewAdaptor extends RecyclerView.Adapter<MyRecyclerViewAdaptor.MyViewHolder> {
    Context context;
    List<CurrentAffairsModel> currentAffairsModels;

    public MyRecyclerViewAdaptor(Context context2, List<CurrentAffairsModel> currentAffairsModels2) {
        this.context = context2;
        this.currentAffairsModels = currentAffairsModels2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.current_affairs_universal_temp, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        int colorId = position % 4;
        final CurrentAffairsModel currentAffairsModel = this.currentAffairsModels.get(position);
        if (colorId == 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FAF5F5"));
        } else if (colorId == 1) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FAF5F5"));
        } else if (colorId == 2) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FAF5F5"));
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FAF5F5"));
        }
        holder.textView.setText(currentAffairsModel.getTitle());
        holder.textView.setSelected(true);
        holder.textView1.setText(String.format("Tags: %s", currentAffairsModel.getTag()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            /* class com.example.edunachal.RecycleViewAdaptors.MyRecyclerViewAdaptor.AnonymousClass1 */

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MyRecyclerViewAdaptor.this.context);
                builder.setTitle(currentAffairsModel.getTitle());
                builder.setMessage(currentAffairsModel.getContent());
                builder.setNeutralButton("Continue", new DialogInterface.OnClickListener() {
                    /* class com.example.edunachal.RecycleViewAdaptors.MyRecyclerViewAdaptor.AnonymousClass1.AnonymousClass1 */

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.currentAffairsModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        TextView textView1;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.cardView2);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.textView1 = (TextView) itemView.findViewById(R.id.textView6);
        }
    }
}