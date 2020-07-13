package com.eijun.bottomnavigationview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.eijun.bottomnavigationview.fragment.AccountFragment;
import com.eijun.bottomnavigationview.fragment.FavouriteFragment;
import com.eijun.bottomnavigationview.fragment.HomeFragment;
import com.eijun.bottomnavigationview.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //default = homefragment
        loadFragment(new HomeFragment());

        //listener menu bottomnavigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frl_main, fragment).commit();

            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.home_menu:
                fragment = new HomeFragment();
                break;
            case R.id.search_menu:
                fragment = new SearchFragment();
                break;
            case R.id.favorite_menu:
                fragment = new FavouriteFragment();
                break;
            case R.id.account_menu:
                fragment = new AccountFragment();
                break;
        }

        return loadFragment(fragment);
    }
}