package com.example.foodies.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foodies.data.DataSource;
import com.example.foodies.data.Restaurant;

import java.util.ArrayList;

public class SectionsPagerAdapter extends FragmentStateAdapter {
    ArrayList<Restaurant> allRestaurants = DataSource.getRestaurantList();

    public SectionsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        int size=0;
        for(int i=0; i<allRestaurants.size(); i++)
        {
            if(allRestaurants.get(i).isFeatured()) {
                allRestaurants.add(size, allRestaurants.get(i));
                allRestaurants.remove(i + 1);
                size++;
            }
        }
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        PosterFragment posterFragment = new PosterFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("image",allRestaurants.get(position).getBannerImage());
        bundle.putString("name",allRestaurants.get(position).getName().toString());
        posterFragment.setArguments(bundle);
        return posterFragment;
    }

    @Override
    public int getItemCount() {
        int count=0;
        for (int i=0;i<allRestaurants.size();++i){
            if(allRestaurants.get(i).isFeatured()){
                count++;
            }
            if(count==3){
                break;
            }
        }
        return count;
    }
}
