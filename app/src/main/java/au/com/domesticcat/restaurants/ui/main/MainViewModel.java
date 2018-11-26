package au.com.domesticcat.restaurants.ui.main;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import au.com.domesticcat.restaurants.FirebaseUtil.FirebaseQueryLiveData;
import au.com.domesticcat.restaurants.bean.Restaurant;

public class MainViewModel extends ViewModel {

    private List<Restaurant> mRestaurantList = new ArrayList<>();

    private static final DatabaseReference mRestaurantRef =
            FirebaseDatabase.getInstance().getReference("/restaurants");

    private final FirebaseQueryLiveData mLiveData = new FirebaseQueryLiveData(mRestaurantRef);

    @NonNull
    public LiveData<List<Restaurant>> getRestaurantListLiveData(){

        LiveData<List<Restaurant>> mRestaurantLiveData =
                Transformations.map(mLiveData, new Deserializer());
        return mRestaurantLiveData;
    }

    private class Deserializer implements Function<DataSnapshot, List<Restaurant>>{

        @Override
        public List<Restaurant> apply(DataSnapshot dataSnapshot) {
            mRestaurantList.clear();
            for(DataSnapshot snap : dataSnapshot.getChildren()){
                Restaurant restaurant = snap.getValue(Restaurant.class);
                mRestaurantList.add(restaurant);
            }
            return mRestaurantList;
        }
    }

    /*private final FirebaseQueryLiveData mLiveData = new FirebaseQueryLiveData(RESTAURANT_REF);

    private final LiveData<Restaurant> restaurantLiveData =
            Transformations.map(mLiveData, new Deserializer());

    private class Deserializer implements Function<DataSnapshot, Restaurant> {
        @Override
        public Restaurant apply(DataSnapshot dataSnapshot) {
            return dataSnapshot.getValue(Restaurant.class);
        }
    }

    @NonNull
    public LiveData<Restaurant> getRestaurantLiveData() {
        return restaurantLiveData;
    }

    @NonNull
    public LiveData<DataSnapshot> getDataSnapshotLiveData() {
        return mLiveData;
    }*/
}
