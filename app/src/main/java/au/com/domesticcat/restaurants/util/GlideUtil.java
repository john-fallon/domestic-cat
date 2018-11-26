package au.com.domesticcat.restaurants.util;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class GlideUtil {

    public static void loadImage(String url, ImageView imageView) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}