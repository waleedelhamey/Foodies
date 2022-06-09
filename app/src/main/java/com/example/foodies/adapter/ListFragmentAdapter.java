package com.example.foodies.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foodies.R;
import com.example.foodies.data.Restaurant;

import java.util.ArrayList;

public class ListFragmentAdapter extends ArrayAdapter<Restaurant> {
    private static final String TAG = "List";
    private Context context;
    int resource;
//    boolean isVegan =false;
//    int sizeOfVegan=0;

    public ListFragmentAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Restaurant> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public int getCount() {
//        if(isVegan){
//
//            return sizeOfVegan;
//        }else{
            return super.getCount();
//        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);
        ImageView restaurantImg = (ImageView) convertView.findViewById(R.id.restaurant_img);
        ImageView veganImg = (ImageView) convertView.findViewById(R.id.vegan_icon);

        TextView restName = (TextView) convertView.findViewById(R.id.restaurant_name_txt);
        TextView restRate = (TextView) convertView.findViewById(R.id.restaurant_rate_txt);
        TextView restMinPrice = (TextView) convertView.findViewById(R.id.restaurant_delviery_fee_txt);
        TextView restDeliveryTime = (TextView) convertView.findViewById(R.id.restaurant_delivery_time_txt);

        String restname= getItem(position).getName()+", "+getItem(position).getAddress1()+", "+getItem(position).getCity();
        restaurantImg.setImageResource(getItem(position).getBannerImage());
        restName.setText(restname);
        restRate.setText(String.valueOf(getItem(position).getRating()));
        restMinPrice.setText("$"+String.valueOf(getItem(position).getMinPrice())+" Minimum Price^-");
        restDeliveryTime.setText(getItem(position).getDeliveryTime()+" min");
        if(getItem(position).isVegetarian()==false){
            veganImg.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }
    public void updateValues(ArrayList<Restaurant> allRestaurants) {
        this.clear();
        this.addAll(allRestaurants);
        this.notifyDataSetChanged();
    }
//    public void setSizeOfVegan(int size){
//        this.sizeOfVegan = size;
//    }
//    public void setIsVegan(boolean isvegan){
//        this.isVegan = isvegan;
//    }
}
