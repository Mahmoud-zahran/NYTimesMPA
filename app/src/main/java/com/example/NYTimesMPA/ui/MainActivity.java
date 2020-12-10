package com.example.NYTimesMPA.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.NYTimesMPA.databinding.ActivityMainBinding;
import com.example.NYTimesMPA.ui.fragments.ConnectionLost;
import com.example.NYTimesMPA.ui.fragments.DetailsFragment;
import com.example.NYTimesMPA.ui.fragments.Home;
import com.example.NYTimesMPA.R;


import java.net.InetAddress;

import dagger.hilt.android.AndroidEntryPoint;
/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity  {
    private ActivityMainBinding binding;
    private boolean isFavoriteListVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar.getRoot());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (!isNetworkConnected()/*||!isInternetAvailable()*/){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                    .commit();

        }else{
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                .commit();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.openFav){
            isFavoriteListVisible = false;

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new DetailsFragment())
                            .commit();
        }
        if (item.getItemId() == R.id.openHome){
            isFavoriteListVisible = false;
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }

    public void switchContent(int id, Fragment fragment) {
//        etSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Favorites())
//                        .commit();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, fragment.toString());
        ft.addToBackStack(null);
        ft.commit();
    }
}
