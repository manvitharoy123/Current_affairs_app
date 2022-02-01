package data.example.edunachal.adapters;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.edunachal.R;
import data.example.edunachal.models.TimetableModel;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{

    private List<TimetableModel> list;

    public ListAdapter(List<TimetableModel> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int i) {
        TimetableModel timetable = list.get(i);
        listViewHolder.subName.setText(timetable.subName);
        listViewHolder.subHour.setText(timetable.hour + "");
        listViewHolder.subCode.setText(timetable.subCode);
        listViewHolder.roomNo.setText(timetable.roomNo);
        listViewHolder.facName.setText(timetable.facName);
        listViewHolder.time.setText(timetable.time);
        listViewHolder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(listViewHolder.getAdapterPosition(), 0, 0, "Delete");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{

        TextView subName, subHour, subCode, roomNo, facName, time;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            subName = itemView.findViewById(R.id.tv_subject_name);
            subHour = itemView.findViewById(R.id.tv_subject_hour);
            subCode = itemView.findViewById(R.id.tv_subject_code);
            roomNo = itemView.findViewById(R.id.tv_room_no);
            facName = itemView.findViewById(R.id.tv_faculty_name);
            time = itemView.findViewById(R.id.tv_time);
        }
    }
}
