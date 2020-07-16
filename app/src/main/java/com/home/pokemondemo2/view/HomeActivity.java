package com.home.pokemondemo2.view;

import androidx.appcompat.app.AppCompatActivity;

import com.home.pokemondemo2.R;
import com.home.pokemondemo2.databinding.ActivityHomeBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new HomeFragment())
                .commit();
    }
}
