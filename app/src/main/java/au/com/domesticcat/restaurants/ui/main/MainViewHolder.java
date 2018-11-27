package au.com.domesticcat.restaurants.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import au.com.domesticcat.restaurants.R;
import au.com.domesticcat.restaurants.bean.Restaurant;
import au.com.domesticcat.restaurants.util.GlideUtil;

public class MainViewHolder extends RecyclerView.ViewHolder {
    private TextView mAddress;
    private ImageView mFeatureImage;
    private TextView mName;


    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        mAddress = itemView.findViewById(R.id.textView_address);
        mFeatureImage = itemView.findViewById(R.id.imageView_feature_image);
        mName = itemView.findViewById(R.id.textView_name);
    }

    public void setItem(Restaurant item){
        GlideUtil.loadImage(item.getFeatureImageUrl(), mFeatureImage);
        mName.setText(item.getName());
        mAddress.setText(item.getAddress());
    }
}
