package au.com.domesticcat.restaurants.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import au.com.domesticcat.restaurants.R;
import au.com.domesticcat.restaurants.bean.Restaurant;

import static au.com.domesticcat.restaurants.util.Util.sizeOf;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private LayoutInflater mInflater;
    private List<Restaurant> mItems;

    public MainRecyclerAdapter(LayoutInflater inflater, List<Restaurant> items) {
        mInflater = inflater;
        mItems = items;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mInflater.inflate(R.layout.item_rv_main, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.setItem(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sizeOf(mItems);
    }

    public void setItems(List<Restaurant> list) {
        mItems = list;
        notifyDataSetChanged();
    }

    public Restaurant getItem(int position) {
        if (position > mItems.size() - 1) {
            return new Restaurant();
        } else {
            return mItems.get(position);
        }
    }
}