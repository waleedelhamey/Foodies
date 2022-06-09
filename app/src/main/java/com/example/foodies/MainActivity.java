package com.example.foodies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.foodies.data.DataSource;
import com.example.foodies.data.Restaurant;
import com.example.foodies.fragments.FragmentList;
import com.example.foodies.fragments.SectionsPagerAdapter;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator2;
import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    SectionsPagerAdapter adapter;
    CircleIndicator3 circleIndicator;
    FragmentList listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        circleIndicator = findViewById(R.id.indicator);
        viewPager= findViewById(R.id.viewpager);
        adapter = new SectionsPagerAdapter(getSupportFragmentManager(),this.getLifecycle());
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);

        listFragment = new FragmentList();
        Bundle bundle = new Bundle();
        bundle.putString("filter", "main");
        listFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.list,listFragment).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.price_high_to_low:
                listFragment = new FragmentList();
                Bundle bundle = new Bundle();
                bundle.putString("filter","price_high_to_low");
                listFragment.setArguments(bundle);
                Toast.makeText(MainActivity.this,"Price high to low",Toast.LENGTH_LONG).show();

                getSupportFragmentManager().beginTransaction().replace(R.id.list,listFragment).commit();
                break;
            case R.id.price_low_to_high:
                listFragment = new FragmentList();
                Bundle bundle2 = new Bundle();
                bundle2.putString("filter","price_low_to_high");
                listFragment.setArguments(bundle2);
                Toast.makeText(MainActivity.this,"Price low to high",Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.list,listFragment).commit();
                break;
            case R.id.deleviry_fee:
                listFragment = new FragmentList();
                Bundle bundle3= new Bundle();
                bundle3.putString("filter","deleviry_fee");
                listFragment.setArguments(bundle3);
                Toast.makeText(MainActivity.this,"Deleviry fee",Toast.LENGTH_LONG).show();

                getSupportFragmentManager().beginTransaction().replace(R.id.list,listFragment).commit();
                break;
            case R.id.rating:
                listFragment = new FragmentList();
                Bundle bundle4= new Bundle();
                bundle4.putString("filter","rating");
                listFragment.setArguments(bundle4);
                Toast.makeText(MainActivity.this,"Rating",Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.list,listFragment).commit();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}