package com.example.foodies.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.foodies.MainActivity;
import com.example.foodies.R;
import com.example.foodies.adapter.ListFragmentAdapter;
import com.example.foodies.data.DataSource;
import com.example.foodies.data.Restaurant;

import java.util.ArrayList;

public class FragmentList extends ListFragment  {
    ListView listView;

    public FragmentList() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ArrayList<Restaurant> allRestaurants = new ArrayList<>();
        allRestaurants = DataSource.getRestaurantList();
        listView = view.findViewById(R.id.list);
        String filter ="main";
        if (getArguments() != null) {
            filter = getArguments().getString("filter");
        }

        ListFragmentAdapter adapter = new ListFragmentAdapter(getActivity(), R.layout.item_view,allRestaurants);
        setListAdapter(adapter);
        if(filter.equals("deleviry_fee")){
            sortDeleviryFee(allRestaurants);
            adapter.notifyDataSetChanged();
            setListAdapter(adapter);

        }else if(filter.equals("price_high_to_low")){
            sortPriceHighToLow(allRestaurants);
            adapter.notifyDataSetChanged();
            setListAdapter(adapter);

        }else if(filter.equals("price_low_to_high")){
            sortPriceLowToHigh(allRestaurants);
            adapter.notifyDataSetChanged();
            setListAdapter(adapter);

        }else if(filter.equals("rating")){
            getRating(allRestaurants);
            adapter.notifyDataSetChanged();
            setListAdapter(adapter);
        }
        return view;

    }

    private void  sortDeleviryFee(ArrayList<Restaurant> allRestaurants)
    {
        for(int i=0; i<allRestaurants.size(); i++)
        {
            for(int j=i+1; j<allRestaurants.size(); j++)
            {
                if(allRestaurants.get(j).getDeliveryFee() <= allRestaurants.get(i).getDeliveryFee()) {
                    allRestaurants.add(i,allRestaurants.get(j));
                    allRestaurants.remove(j+1);
                }
                else {
                    allRestaurants.add(i, allRestaurants.get(i));
                    allRestaurants.remove(i + 1);
                }
            }
        }

    }

    public void sortPriceLowToHigh(ArrayList<Restaurant> allRestaurants)
    {
        for(int i=0; i<allRestaurants.size(); i++)
        {
            for(int j=i+1; j<allRestaurants.size(); j++)
            {
                if(allRestaurants.get(j).getMinPrice() <= allRestaurants.get(i).getMinPrice()) {
                    allRestaurants.add(i,allRestaurants.get(j));
                    allRestaurants.remove(j+1);
                }
                else {
                    allRestaurants.add(i, allRestaurants.get(i));
                    allRestaurants.remove(i + 1);
                }
            }
        }
    }

    public void sortPriceHighToLow(ArrayList<Restaurant> allRestaurants)
    {
        for(int i=0; i<allRestaurants.size(); i++)
        {
            for(int j=i+1; j<allRestaurants.size(); j++)
            {
                if(allRestaurants.get(j).getMinPrice() >= allRestaurants.get(i).getMinPrice()) {
                    allRestaurants.add(i,allRestaurants.get(j));
                    allRestaurants.remove(j+1);
                }
                else {
                    allRestaurants.add(i, allRestaurants.get(i));
                    allRestaurants.remove(i + 1);
                }
            }
        }
    }

    public void getRating(ArrayList<Restaurant> allRestaurants)
    {
        for(int i=0; i<allRestaurants.size(); i++)
        {
            for(int j=i+1; j<allRestaurants.size(); j++)
            {
                if(allRestaurants.get(j).getRating() >= allRestaurants.get(i).getRating()) {
                    allRestaurants.add(i,allRestaurants.get(j));
                    allRestaurants.remove(j+1);
                }
                else {
                    allRestaurants.add(i, allRestaurants.get(i));
                    allRestaurants.remove(i + 1);
                }
            }
        }
    }

}


