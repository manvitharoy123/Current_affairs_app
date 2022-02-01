package data.example.edunachal;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdaptor extends FragmentStateAdapter {
    List<String> dateList;

    public ViewPagerAdaptor(FragmentActivity fragmentActivity, List<String> dateList2) {
        super(fragmentActivity);
        this.dateList = dateList2;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("date", this.dateList.get(position));
        CurrentAffairsFragment currentAffairsFragment = new CurrentAffairsFragment();
        currentAffairsFragment.setArguments(bundle);
        return currentAffairsFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dateList.size();
    }
}